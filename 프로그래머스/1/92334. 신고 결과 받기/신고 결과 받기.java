import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> report_cnt_map = new HashMap<>();//<유저 id, 신고 당한 횟수>
        Map<String, Set<String>> report_list_map = new HashMap<>();//<유저 id, 신고한 id 리스트>
        
        for(String r:report){
            String[] arr = r.split(" ");
            String reporter = arr[0];//신고한 사람
            String reported = arr[1];//신고 당한 사람
            
            // 유저가 신고한 리스트 
            report_list_map.putIfAbsent(reporter, new HashSet<>());
            Set<String> temp = report_list_map.get(reporter);
            temp.add(reported);
            report_list_map.put(reporter,temp);
        }
        for(Set<String> reportedlist:report_list_map.values() ){
            for(String reported:reportedlist){
                report_cnt_map.put(reported,report_cnt_map.getOrDefault(reported,0)+1);
            }
        }
        //k번 이상 신고당한 유저 저장
        Map<String,Integer> kill = new HashMap<>();
        for(Map.Entry<String, Integer> entry:report_cnt_map.entrySet()){
            if(entry.getValue()>=k){
                kill.put(entry.getKey(),0);//나중에 찾기 쉬울려고 일부러 map 선택
            }
            
        }
        for(int i=0;i<id_list.length;i++){
            String user = id_list[i];
            int cnt = 0;
            Set<String> list = report_list_map.getOrDefault(user, new HashSet<>());
            
            for(String r:list){
                if(kill.containsKey(r)){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
// 유저는 한번에 한명을 신고
// 동일한 유저에 대한 신고는 1회 처리
// k번 이상 신고된 유저는 이용 정지
// 해당 유저를 신고한 유저에게 메일 발송
