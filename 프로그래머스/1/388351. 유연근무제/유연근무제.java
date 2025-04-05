class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int stday = startday-1;//%7을 사용하기 위해서
        int num = schedules.length;//직원들의 수
        
        int hopetime;//출근 희망 시각
        int plus10;//+10한 시각
        boolean flag = true;
        int cnt=0;
        for(int i=0;i<num;i++){
            int curday = stday;
            hopetime = schedules[i];
            plus10 = schedules[i]+10;//이걸 이렇게 그냥 10하면 안됨
            if(plus10 % 100 >= 60){
                plus10 += 40;
            }
            for(int j=0;j<7;j++){
                if(curday%7 == 5 || curday%7 ==6){
                    curday++;
                    continue;
                }
                if(timelogs[i][j]>plus10){//보다 늦게 출근하면
                    flag = false;
                    System.out.println(schedules[i]);
                    break;
                }
                curday++;
            }
            if(flag){
                
                cnt++;
            }
            flag = true;
        }

        return cnt;
    }
}