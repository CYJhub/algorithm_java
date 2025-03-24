import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        //컨테이너 위에 있는 택배 상자 순서
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=order.length;i++){
            queue.offer(i);
        }
        //보조 컨테이너
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<order.length;i++){
            if(!queue.isEmpty()&&queue.peek()<=order[i]){
                for(int j=queue.peek();j<order[i];j++){
                    stack.push(j);
                    queue.poll();
                }
                queue.poll();//queue.peek()==order[i]
                answer++;
            }
            else{
                if(stack.pop()<=order[i]){
                    answer++;
                }
                else{
                    break;
                }
            }
            
        }
        return answer;
    }
}
