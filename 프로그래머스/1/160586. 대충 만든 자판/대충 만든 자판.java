import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int len = keymap.length; // 키맵의 개수
        Map<Character, Integer> map = new HashMap<>();// 각 알파벳이 나오는 취소 위치를 저장하는 맵
        
        for(String s: keymap){
            for(int i=0;i<s.length();i++){
                char key = s.charAt(i);
                
                int value = map.getOrDefault(key,i+1);
                
                map.put(key, Math.min(value,i+1)); // 두번째 이상 나온 경우 첫번째 위치가 들어가도록
            }
        }//<알바펫, 나오는 최소 위치> map 생성
        
        int sum=0;
        
        for(int j=0;j<targets.length;j++){
            for(int i=0;i<targets[j].length();i++){
                char c = targets[j].charAt(i);
                
                if(map.containsKey(c)){
                    answer[j] += map.get(c);
                }
                else{
                    answer[j] = -1;
                    break;
                }
            }
            
        }
        return answer;
    }
}