import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>(); 
        String answer = "";
        for(int i=0;i<participant.length;i++){
            if (result.containsKey(participant[i])){ // 동명이인일 때
                result.put(participant[i],result.get(participant[i])+1);
            }
            else{
                result.put(participant[i],1);
            }
        }
        for(int j=0;j<completion.length;j++){
            result.put(completion[j], result.get(completion[j])-1);
        }
        for(Map.Entry<String, Integer> entry:result.entrySet()){
            if (entry.getValue() == 1){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
