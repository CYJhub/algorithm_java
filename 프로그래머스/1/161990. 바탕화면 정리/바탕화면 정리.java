import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int N = wallpaper[0].length();
        
        int lux=Integer.MAX_VALUE;
        int luy=Integer.MAX_VALUE;
        int rdx=-1;
        int rdy=-1;
        
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<N;j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(lux>i){//현재 최소 좌표보다 작은 값이 있다면
                        lux = i;
                    }
                    if(luy>j){
                        luy = j;
                    }
                    if(rdx<i){//현재 최대 좌표보다 큰 값이 있다면
                        rdx=i;
                    }
                    if(rdy<j){
                        rdy=j;
                    }
                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx+1;
        answer[3] = rdy+1;
        
        return answer;
    }
}

