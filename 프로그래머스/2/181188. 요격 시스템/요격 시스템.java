import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]);//e를 기준으로 오름차순 정렬
        
        int before = 0;
        for(int i=0;i<targets.length;i++){
            if(before<=targets[i][0]){
                before = targets[i][1];
                answer++;
                
            }
        }

        return answer;
    }
}
