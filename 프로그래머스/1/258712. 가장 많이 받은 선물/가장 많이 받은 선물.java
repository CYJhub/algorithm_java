import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] gift = new int[friends.length][friends.length];
        Map<String,Integer> numberMap = new HashMap<>();//<사람이름,인덱스 번호>
        
        for(int i=0;i<friends.length;i++){
            numberMap.put(friends[i],i);
        }
        
        Map<String,Integer> give = new HashMap<>();//<준사람, 횟수> 그저 몇번 주고 받았는지만 체크
        Map<String,Integer> receive = new HashMap<>();//<받은사람, 횟수>
        for(int i=0;i<gifts.length;i++){
            String[] gArr = gifts[i].split(" ");//<준사람, 받은사람>
            int givenum = numberMap.get(gArr[0]);//준사람의 인덱스
            int receivenum = numberMap.get(gArr[1]);//받은사람의 인덱스
            gift[givenum][receivenum]++;//선물을 주고 받음
            give.put(gArr[0],give.getOrDefault(gArr[0],0)+1);
            receive.put(gArr[1],receive.getOrDefault(gArr[1],0)+1);
        }
        
        Map<Integer,Integer> gift_score_map = new HashMap<>();//<이름:선물지수>
        for(int i=0;i<friends.length;i++){
            int g = give.getOrDefault(friends[i],0);
            int r = receive.getOrDefault(friends[i],0);
            gift_score_map.put(numberMap.get(friends[i]),g-r);
        }
        
        int max = -1;
        for(int i=0;i<friends.length;i++){
            int cnt=0;
            int row = numberMap.get(friends[i]);
            for(int j=0;j<friends.length;j++){
                if(row!=j){//자기 자신이 아닌 경우만
                    if(gift[row][j]>gift[j][row]){
                        cnt++;
                    }
                    else if((gift[row][j]==0 && gift[j][row]==0) || gift[row][j]==gift[j][row]){
                        if(gift_score_map.get(row)>gift_score_map.get(j)){
                            cnt++;
                        }
                    }
                }
            }
            max = Math.max(max,cnt);
        }

        System.out.print(gift_score_map);
        
        return max;
    }
}