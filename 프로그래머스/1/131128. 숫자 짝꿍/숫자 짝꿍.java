import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        List<Character> result = new ArrayList<>();
        
        Map<Character,Integer> yMap = new HashMap<>();
        
        for(Character y:Y.toCharArray()){
            yMap.put(y,yMap.getOrDefault(y,0)+1);
        }
        for(Character x:X.toCharArray()){
            if(yMap.containsKey(x)){
                result.add(x);
                yMap.put(x,yMap.get(x)-1);
                if (yMap.get(x) == 0) {
                    yMap.remove(x);
                }
            }
        }
        if(result.size()==0){
            return "-1";
        }
        
        result.sort((a,b)->b-a);//내림차순
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.size();i++){
            sb.append(result.get(i));
            
        }
        answer = sb.toString();
        if(answer.replace("0","").isEmpty()){
            return "0";
        }
        return answer;
    }
}
//공통으로 나타나는 정수를 이용해서 만들 수 있는 가장 큰 정수
//0으로만 구성되어 있으면 0