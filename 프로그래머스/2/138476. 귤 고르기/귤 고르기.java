import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> tan = new HashMap<>();//<귤의 종류:개수>
        for(int t:tangerine){
            tan.put(t,tan.getOrDefault(t,0)+1);
        }
        
        List<Integer> lst = new ArrayList<>(tan.keySet());
        lst.sort((x,y)->tan.get(y).compareTo(tan.get(x)));//귤의 개수를 기준으로 내림차순 정렬
        
        int idx=0;
        // 2:2, 3:2, 5:2, 1:1, 4:1
        
        while(k>0){
            int cnt = tan.get(lst.get(idx));
            k -= cnt;
            idx++;
            answer++;
        }

//         while(k>0){
//             int cnt = tan.get(lst.get(idx));
//             cnt -= 1;
//             tan.put(lst.get(idx), cnt);
//             k--;
//             if(cnt==0){
//                 idx++;
//                 answer++;
//             }
            
//         }
        
        return answer;
    }
}
// 목표: 서로 다른 종류의 수를 최소화
// (1) 2 2 3 3 (4) 5 5 
// 2:2, 3:2, 5:2, 1:1, 4:1