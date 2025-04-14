import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(isOk(s)){
            answer++;
        }
        for(int i=0;i<s.length()-1;i++){
            s = shift(s);
            if(isOk(s)){
                answer++;
            }
        }
        return answer;
    }
    private static boolean isOk(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()=='(' && c==')'){
                    stack.pop();
                }
                else if(stack.peek()=='{' && c=='}'){
                    stack.pop();
                }
                else if(stack.peek()=='[' && c==']'){
                    stack.pop();
                }
            }
            
        }
        return stack.isEmpty();
    }
    private static String shift(String s){
        return s.substring(1) + s.charAt(0);//맨 왼쪽에 있는 걸 오른쪽으로 옮김.
    }
}
// (), [], {}
// 왼쪽으로 칸만큼 회전하는 함수 -> 큐를 써서?
// 올바른 괄호인지 체크하는 함수