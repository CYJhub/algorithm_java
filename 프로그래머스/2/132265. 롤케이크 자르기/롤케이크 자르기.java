import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int answer=0;
        Map<Integer, Integer> map = new HashMap<>();//<토핑의 종류: 개수>
        for(int top:topping){
            map.put(top, map.getOrDefault(top,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int top:topping){
            set.add(top);
            
            map.put(top,map.get(top)-1);
            if(map.get(top)==0){
                map.remove(top);
            }
            if(map.size()==set.size()){
                answer++;
            }
        }
        return answer;
    }
        
}