import java.util.Stack;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<food.length;i++){
            int temp = food[i]/2;
            if (temp == 0){
                continue;
            }
            else{
                for(int j=0;j<temp;j++){
                    stack.push(i);
                    answer.append(i);
                }
            }
            
        }
        answer.append(0);
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        return answer.toString();
    }
}
