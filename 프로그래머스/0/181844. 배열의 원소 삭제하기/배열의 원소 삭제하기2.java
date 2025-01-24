// hashmap을 사용해서 시간을 단축

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        // 검색 속도를 개선하기 위해 HashSet을 사용
        Set<Integer> deleteset = new HashSet<>();
        
        for(int delete : delete_list){
            deleteset.add(delete);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int num : arr){
            if (!deleteset.contains(num)){
                answer.add(num);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
