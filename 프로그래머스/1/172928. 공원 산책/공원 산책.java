class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int R = park.length;
        int C = park[0].length();
        
        int curx = -1;
        int cury = -1;
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};//N S W E
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(park[i].charAt(j)=='S'){
                    curx = i;
                    cury = j;
                }
            }
        }
        int Didx = -1;
        for(String route:routes){
            String[] arr = route.split(" ");
            String dir = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            boolean isCheck = true;
            
            int tempx = curx;
            int tempy = cury;
            
            
            if(dir.equals("N")){//상
                Didx = 0;
            }else if(dir.equals("S")){//하
                Didx = 1;
            }
            else if(dir.equals("W")){//좌
                Didx = 2;
            }
            else{//우
                Didx = 3;
            }
            
            for(int i=0;i<num;i++){
                tempx += directions[Didx][0];
                tempy += directions[Didx][1];
                
                if(!isRange(tempx,tempy,R,C) || park[tempx].charAt(tempy)=='X'){
                    isCheck = false;
                }
            }
            if(isCheck){
                curx = tempx;
                cury = tempy;
            }
        }
        answer[0] = curx;
        answer[1] = cury;
        return answer;
        
    }
    public static boolean isRange(int x,int y, int R,int C){
        return x>=0 && x<R && y>=0 && y<C;
    }
        
    
}
