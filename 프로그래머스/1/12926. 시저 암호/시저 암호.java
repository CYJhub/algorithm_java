class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char ch = ' '; // 예제 문자
        int asciiValue = (int) ch; // char → int 변환
        System.out.println("ASCII 값: " + asciiValue);
        char key;
        for(int i=0;i<s.length();i++){
            int ascii = (int)s.charAt(i);
            if(ascii == 32){
                answer += " ";
            }
            else if(ascii<=90) {
                if(ascii+n >90){
                    key = (char) (ascii + n -26);
                }
                else{
                    key = (char) (ascii + n);
                }
                answer += String.valueOf(key);
            }
            else if(ascii<=122){
                if(ascii+n >122){
                    key = (char) (ascii + n -26);
                }
                else{
                    key = (char) (ascii + n);
                }
                answer += String.valueOf(key);
            }
        }
        return answer;
    }
}
//아스키 코드 48 65(대문자) 97(소문자) 32(공백) 97+25