import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        int zero = countZero(lottos);//0의 개수 세기
        
        
        List<Integer> win = new ArrayList<>();
        for(int i=0;i<6;i++){
            win.add(win_nums[i]);
        }
        
        int ans = 0;//일단 맞힌 개수
        
        for(int i=0;i<6;i++){
            if(win.contains(lottos[i])){
                ans++;
            }
        }
        
        System.out.println(ans);
        int max = ans+zero;
        int min = ans;
        
        if(max>=6){
            answer[0] = 1;
        }
        else if(max==5){
            answer[0] = 2;
        }
        else if(max==4){
                answer[0] = 3;
        }
        else if(max==3){
                answer[0] = 4;
        }
        else if(max==2){
                answer[0] = 5;
        }
        else{
            answer[0] = 6;
        }
        
        if(min>=6){
            answer[1] = 1;
        }
        else if(min==5){
            answer[1] = 2;
        }
        else if(min==4){
                answer[1] = 3;
        }
        else if(min==3){
                answer[1] = 4;
        }
        else if(min==2){
                answer[1] = 5;
        }
        else{
            answer[1] = 6;
        }
        
        
        return answer;
    }
    
    
    
    public int countZero(int[] lottos){
        int zero = 0;//0의 개수
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                zero++;
            }
        }
        return zero;
    }
}
//알수없는 번호는 0
//일단 맞힌 개수
//+- 0의 개수
//최고 점수 = 일단 맞힌 개수 + 0의 개수
//최저 점수 = 일단 맞힌 개수