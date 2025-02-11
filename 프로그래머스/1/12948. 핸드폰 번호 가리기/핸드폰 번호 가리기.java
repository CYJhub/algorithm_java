class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();//9
        int star = len - 4;//5
        for(int i=0;i<star;i++){
            answer += "*";
        }
        answer += phone_number.substring(star);
        return answer;
    }
}