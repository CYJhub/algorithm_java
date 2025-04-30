import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String answer = "";
        int video_len_time = convertTime(video_len);
        int time = convertTime(pos);
        
        System.out.println(time);
        
        int op_start_time = convertTime(op_start);
        int op_end_time = convertTime(op_end);
        
        for(String com:commands){
            if(op_start_time<=time && time<=op_end_time){
                time = op_end_time;
            }
            if(com.equals("prev")){
                time -= 10;
                if(time<=0){
                    time=0;
                }
            }else if(com.equals("next")){
                time += 10;
                if(time>=video_len_time){
                    time=video_len_time;
                }
            }
            if(op_start_time<=time && time<=op_end_time){
                time = op_end_time;
            }
        }
        
        String min = String.valueOf(time/60);
        String sec = String.valueOf(time%60);
        
        if(min.length()<2){
            while(min.length()<2){
                min = "0"+min;
            }
        }
        
        if(sec.length()<2){
            while(sec.length()<2){
                sec = "0"+sec;
            }
        }
        
        return min+":"+sec;
    }
    private static int convertTime(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
}



