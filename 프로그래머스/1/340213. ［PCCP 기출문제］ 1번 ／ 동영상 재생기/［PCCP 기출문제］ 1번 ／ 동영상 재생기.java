class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int cur_time = toDate(pos);//현재 시간
        int total_time = toDate(video_len);//전체 시간
        int open_st = toDate(op_start);//오프닝 시작시간
        int open_end = toDate(op_end);//오프닝 끝나는 시간
        
        int next;
        for(String com:commands){
             // 오프닝 구간에 속한다면 오프닝이 끝나는 위치로 이동!! 
            if(open_st <= cur_time && cur_time <= open_end){
                cur_time = open_end;
            }
            if(com.equals("next")){
                cur_time += 10;//10초 후로 이동
                if(cur_time>total_time){
                    cur_time = total_time;//만약 끝나는 시간을 넘어간다면 끝시간으로 설정
                }
            }
            else if(com.equals("prev")){
                cur_time -= 10;//10초 전으로 이동
                if(cur_time<0){
                    cur_time = 0;//0보다 작아지면 시작위치로 설정
                }
            }
            // 오프닝 구간에 속한다면 오프닝이 끝나는 위치로 이동!! 
            if(open_st <= cur_time && cur_time <= open_end){
                cur_time = open_end;
            }
        }
     
        return fomatDate(cur_time);
    }
    
    private static int toDate(String date){
        String[] arr = date.split(":");
        int minute = Integer.parseInt(arr[0]);
        int sec = Integer.parseInt(arr[1]);
        return (minute*60) + sec;
    }
    
    private static String fomatDate(int time){
        String minute = String.valueOf(time / 60);
        String sec = String.valueOf(time % 60);
        
        if(minute.length()<2){//한자리수라면,
            minute = "0"+minute;
            
        }
        if(sec.length()<2){
            sec = "0"+sec;
        }
        return minute + ":" + sec;
    }
}
//10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 

//10초 전으로 이동할 때 현재 위치가 10초 미만일 경우 처음 위치로 이동

