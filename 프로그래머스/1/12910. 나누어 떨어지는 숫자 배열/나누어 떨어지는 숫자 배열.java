import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int a:arr){
            if(a%divisor == 0){
                answer.add(a);
            }
        }
        answer.sort((a,b) -> a-b);
        if(answer.size()==0){
            return new int[]{-1};
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}