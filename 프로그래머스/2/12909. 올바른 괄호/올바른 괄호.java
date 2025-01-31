import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        boolean answer = false;
        for(char c:s.toCharArray()){
            if (c == '('){
                st.push(c);
            }
            else{
                if(st.isEmpty()){ // 처음부터 ) 가 나오는 경우
                    return false;
                }
                st.pop();
            }
        }
        if(st.isEmpty()){
            answer=true;
        }
        return answer;
    }
}