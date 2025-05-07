class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[]  answer = new int[2];
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};//N S W E
        
        int R = park.length;
        int C = park[0].length();
        //시작 지점
        int curx= -1;
        int cury= -1;
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(park[i].charAt(j)=='S'){
                    curx = i;
                    cury = j;
                    break;
                    
                }
            }
        }
        for(String route:routes){
            String[] arr = route.split(" ");
            String dir = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            int tempx = curx;
            int tempy = cury;
            boolean isCheck = true;

            int idx = -1;
            if(dir.equals("N")){
                idx=0;
            }else if(dir.equals("S")){
                idx=1;
            }
            else if(dir.equals("W")){
                idx=2;
            }
            else if(dir.equals("E")){
                idx=3;
            }
            
            for(int i=0;i<num;i++){
                tempx += directions[idx][0];
                tempy += directions[idx][1];
                
                if(!isRange(tempx,tempy,R,C) || park[tempx].charAt(tempy)=='X'){
                    isCheck = false;
                    break;
                }
                
            }
            if(isCheck){
                    curx = tempx;
                    cury = tempy;

                }
            
        }
        answer[0]=curx;
        answer[1]=cury;
        
        return answer;
    }
    public static boolean isRange(int x,int y,int R, int C){
        return x>=0 && x<R && y>=0 && y<C ;
    }
        
    
}
