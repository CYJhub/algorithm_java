import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);//<원하는 물품:수량>
        }
        
        
        if(10>discount.length){
            return 0;
        }
        
        for(int i=0;i<discount.length-9;i++){
            boolean flag = true;
            Map<String,Integer> dMap = new HashMap<>();
            for(int j=0;j<10;j++){
                dMap.put(discount[i+j],dMap.getOrDefault(discount[i+j],0)+1);
            }
            for(String good:map.keySet()){
                if(map.get(good)!=dMap.get(good) || !dMap.containsKey(good)){
                    flag = false;
                }
            }
            if(flag){
                answer++;
            }
            
        }
        
    
    
        return answer;
    }
    
}
// 치킨: 1, 사과: 4, 바나나: 4, 쌀:2, 돼지고기: 2, 냄비:1
// 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나
// 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개
