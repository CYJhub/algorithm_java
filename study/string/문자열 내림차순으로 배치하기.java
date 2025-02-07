import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Character[] str = new Character[s.length()];
        
        Stack<Character> st1 = new Stack<>();//소문자
        Stack<Character> st2 = new Stack<>();//대문자
        
        for(int i=0;i<s.length();i++){
            str[i] = s.charAt(i);
        }
        Arrays.sort(str);//오름차순 정렬
        
        for(int i=0;i<s.length();i++){
            if(str[i]<=90){//대문자
                st2.push(str[i]);
            }
            else{
                st1.push(str[i]);
            }
        }
        
        String ans1 = "";
        String ans2 = "";
        while(!st1.isEmpty()){
            ans1 += st1.pop();
        }
        while(!st2.isEmpty()){
            ans2 += st2.pop();
        }
        return ans1+ans2;
    }
}
// array 배열의 정렬 메소드를 사용
