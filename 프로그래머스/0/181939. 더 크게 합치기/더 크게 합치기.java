import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        if (str1.concat(str2).compareTo(str2.concat(str1))>0){
            answer = Integer.parseInt(str1.concat(str2));
        }
        else{
            answer = Integer.parseInt(str2.concat(str1));
        }
        return answer;
    }
}