import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>(); 
        String answer = "";
        for(String s: participant){
            // if (result.containsKey(participant[i])){ // 동명이인일 때
            //     result.put(participant[i],result.get(participant[i])+1);
            // }
            // else{
            //     result.put(participant[i],1);
            // }
            result.put(s, result.getOrDefault(s,0)+1);
        }
        for(String c: completion) result.put(c, result.get(c)-1);
        for(Map.Entry<String, Integer> entry:result.entrySet()){
            if (entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}