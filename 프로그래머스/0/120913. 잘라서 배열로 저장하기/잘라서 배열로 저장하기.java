// 문자열을 for 문을 이용해 하나씩 잘라서 n개씩 묶은 다음에 문자열 배열에 저장한다.

class 잘라서배열로저장하기 {
    public String[] solution(String my_str, int n) {
        int cnt = (my_str.length() + n - 1) /n ;
        String[] answer = new String[cnt];
        
        for(int i=0;i<my_str.length();i+=n){
                answer[i/n] = my_str.substring(i,Math.min(i+n,my_str.length()));
            
        }
        return answer;
    }
}