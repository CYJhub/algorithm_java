class Solution {
    public String solution(String s) {
        int len = s.length(); // 글자의 길이
        
        StringBuilder answer = new StringBuilder();
        
        if ((len%2)==0){
            answer.append(String.valueOf(s.charAt(len/2-1)));
            answer.append(String.valueOf(s.charAt(len/2)));
        }
        else{
            answer.append(String.valueOf(s.charAt(len/2)));
        }
        
        return answer.toString();
    }
}