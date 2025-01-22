import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        Arrays.sort(strings,(s1,s2) ->
                    {
                        int result = Character.compare(s1.charAt(n),s2.charAt(n));
                        if(result == 0){
                            result = s1.compareTo(s2);
                        }
                        return result;
                    });
        return answer;
    }
}
