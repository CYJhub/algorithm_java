class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str2.contains(str1)){
            answer =1;
        }
        return answer;
    }
}
// str1이 str2의 부분 문자열이라면 .contains 메소드 사용