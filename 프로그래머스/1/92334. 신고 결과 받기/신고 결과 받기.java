import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 같은 유저가 여러 유저를 신고한 경우 반영 안됨.
        //HashMap<String, String> reportMap = new HashMap<>();//<신고한 id,신고당한 id>
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        Map<String, Integer> reportNum = new HashMap<>();//신고당한 id, 횟수>
              
        // set을 사용해서 같은 유저 같은 id 신고할 걸 제거
        Set<String> set = new HashSet<>();
        for(String s:report){
            set.add(s);
        }
        String[] result = set.toArray(new String[0]);
        
        
        for(String s:result){
            String[] rep = s.split(" ");
            String reporter = rep[0];//신고한 사람
            String reported = rep[1];//신고당한 사람
            
            reportMap.putIfAbsent(reporter, new HashSet<>());//신고자가 처음 추가된다면 해시셋 자료구조를 추가
            if(reportMap.get(reporter).add(reported)){//새로운 신고 조합이라면
                reportNum.put(reported, reportNum.getOrDefault(reported,0)+1);
                
            }
            //reportNum.put(rep[1],reportNum.getOrDefault(rep[1],0)+1);
        }
        //System.out.println(reportNum);//잘 나옴
        //muzi=1, neo=2, frodo=2
        
        // k번 이상 신고당한 사람
        Set<String> keys = new HashSet<>();
        for(Map.Entry<String, Integer> entry:reportNum.entrySet()){
            if (entry.getValue()>=k){
                keys.add(entry.getKey());
            }
        }

        // k이상 신고된 유저가 없다면 0반환
        if(keys.size()==0){
            return answer;
        }
        
        for(int i=0;i<id_list.length;i++){
            String user = id_list[i];
            if(reportMap.containsKey(user)){
                for(String reported:reportMap.get(user)){
                    if(keys.contains(reported)){
                        answer[i]++;
                    }
                }
            }
        }
        
        
        
        return answer;
    }
}
// 여러 유저를 신고할 수 있음. 한 유저에 여러번 신고 가능(1회로 산정)
// report에 있는 string을 .split(" ") 으로 두개로 분리
// map에 <신고당한 유저 id, 신고당한 횟수>
// 신고횟수가 k번 이상인 유저 id를 추출해서
// id_list에 있는 아이디의 인덱스를 돌면서 <신고한 id, 신고당한 id>에서 .valueSet에서 저 추출한 유저 id를 가지고 있다면 answer[i]에 1추가
// 근데 그 사람을 신고한 유저 id
// 즉, map을 두번 써야함