import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        Map<String, Integer> num = new HashMap<>();
        num.put("zero",0);
        num.put("one",1);
        num.put("two",2);
        num.put("three",3);
        num.put("four",4);
        num.put("five",5);
        num.put("six",6);
        num.put("seven",7);
        num.put("eight",8);
        num.put("nine",9);
        char[] words = s.toCharArray();//########
        String word = "";
        for(int i=0;i<words.length;i++){
            char c = words[i];
            if('0'<= c && c <='9'){
                answer += c;
            }else{
                word += c;
                if(num.containsKey(word)){
                    answer += String.valueOf(num.get(word));
                    word = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }
}