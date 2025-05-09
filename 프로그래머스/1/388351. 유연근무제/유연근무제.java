class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0;i<timelogs.length;i++){
            int hour = schedules[i]/100;
            int min = schedules[i]%100;
            min+=10;
            if(min>=60){
                hour += 1;
                min -= 60;
            }
            int hope_time = hour*100 + min;
            int st = startday-1;//월요일은 0부터 시작
            
            boolean isCheck = true;
            for(int j=0;j<7;j++){
                st %= 7;
                if(st!=5 && st!=6){
                    if(timelogs[i][j] > hope_time){
                        isCheck = false;//늦게 출근하면 false
                        break;
                    }
                }
                st++;

            }
            if(isCheck){
                answer++;
            }
        }
        
       return answer;
    }
    
}
// 각자 설정한 출근 희망 시각에 늦지 않고 출근한
// 출근 희망 시각 + 10분
// 단, 토일은 상관 없음
// 시*100+분
// 1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일