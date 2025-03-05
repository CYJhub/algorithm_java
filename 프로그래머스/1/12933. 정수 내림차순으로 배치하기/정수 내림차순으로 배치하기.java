import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str = String.valueOf(n).split("");// long 형 수를 분리해서 string 배열로 변환
        Arrays.sort(str, Collections.reverseOrder()); // str 를 내림차순으로 배열
        
        String newStr = "";
        for(String s:str){
            newStr += s;
        }
        answer = Long.parseLong(newStr); // string을 long으로 바꾸기
        return answer;
    }
}
