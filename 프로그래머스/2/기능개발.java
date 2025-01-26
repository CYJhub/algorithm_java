import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        
        int len = progresses.length;
        int[] days = new int[len]; // 개수는 같으므로,
        for(int i=0;i<len;i++){
            days[i] = (100-progresses[i] + speeds[i] - 1)/speeds[i]; // 남은 일수 계산
        }
        int cnt = 1;
        int k = days[0];
        for(int j=1;j<len;j++){
            if(k>=days[j]){
                cnt++;
            }
            else{
                answer.add(cnt);
                cnt = 1;
                k = days[j];
            }
        }
        answer.add(cnt); // 마지막 배포 그룹 추가
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}
