class 배열에서문자열대소문자변환하기 {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int i=0;i<strArr.length;i++){
            if ((i%2)==0){// 소문자로
                answer [i] = strArr[i].toLowerCase();
            }
            else{
                answer [i] = strArr[i].toUpperCase();
            }
            
        }
        return answer;
    }
}