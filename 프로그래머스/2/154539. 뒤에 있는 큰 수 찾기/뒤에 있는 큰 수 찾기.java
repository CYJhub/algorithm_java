import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        //맨 마지막 자리는 무조건 -1들어감
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numbers.length;i++){
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                int idx  = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }
        
        
        return answer;
    }
    
}