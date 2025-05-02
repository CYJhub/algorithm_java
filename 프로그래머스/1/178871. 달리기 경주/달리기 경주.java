import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> map = new HashMap<>();//<선수 이름:인덱스>
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        
        for(String call:callings){
            int idx = map.get(call);//이름이 불린 선수의 현재 위치(=인덱스를 가져옴)
            //swap
            String temp = players[idx];
            players[idx] = players[idx-1];
            players[idx-1] = temp;
            
            map.put(call,idx-1);
            map.put(players[idx],idx);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a,b)->map.get(a)-map.get(b));//인덱스를 기준으로 오름차순
        
        for(int i=0;i<players.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
        
    }
}

// mumu 1등
// soe 2
// po 3
//kai 4
//mine 5
//이름이 한번 불리면 자기 바로 앞 선수랑 자기 바꿈