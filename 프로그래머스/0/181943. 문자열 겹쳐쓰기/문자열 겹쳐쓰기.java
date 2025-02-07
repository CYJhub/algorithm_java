class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String str1 = my_string.substring(0,s);//s전까지 앞부분을 자름.
        int end = s + overwrite_string.length();
        
        answer = str1 + overwrite_string;
        if (end<=my_string.length()){
            answer += my_string.substring(end);
        }
        
        return answer;
    }
}