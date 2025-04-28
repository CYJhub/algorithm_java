import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int r = n%3;
            n /= 3;
            sb.append(r);
        }
        String str = sb.toString();
        for(int i=str.length()-1;i>=0;i--){
            answer += (str.charAt(i)-'0')*(Math.pow(3,(str.length()-i-1)));
            
        }
        return answer;
    }
}