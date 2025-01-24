import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        // 배열이었던 것을 리스트로 바꿈 <- remove 메소드를 사용하기 위해서
        for(int num : arr){
            answer.add(num);
        }
        
        for(int delete : delete_list){
            answer.remove((Integer)delete); // Integer로 감싸서 전달
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
