import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        Arrays.sort(answer);
        // 공백을 제거해야함
        // ["a","b","",""] -> 공백 제거
        
        ArrayList<String> list = new ArrayList<>();
        
        
        for(String str:answer){
            if (str.length()>=1){
                list.add(str);
            }
        }
        
        String[] result = new String[list.size()];
        
        list.toArray(result);
        
        return result;
    }
}