class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder(my_string);
        for(int i=0;i<my_string.length();i++){
            if (my_string.charAt(i)==alp.charAt(0)){
                answer.setCharAt(i,(char)(alp.charAt(0)-32));
            }
        }
        return answer.toString();
    }
}
// 문자열 string은 인덱싱 접근 불가, String.charAt(i)로 접근해야함