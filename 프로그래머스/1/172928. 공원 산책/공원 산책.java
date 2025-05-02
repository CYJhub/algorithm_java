class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[]  answer = new int[2];
        int row = park.length;//세로
        int col = park[0].length();//가로
        
        char[][] grid = new char[row][col];//공원 격자
        
        int curRow = -1;
        int curCol = -1;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = park[i].charAt(j);
                if(park[i].charAt(j)=='S'){//시작점 확인
                    curRow = i;
                    curCol = j;
                }
            }
        }//격자 채우기
        
        
        for(String route:routes){

            
            String[] str = route.split(" ");
            String op = str[0];
            int n = Integer.parseInt(str[1]);
            
            int dx=0;
            int dy=0;
            
            if(op.equals("N")){
                dx=-1;
            }else if(op.equals("S")){
                dx=1;
            }
            else if(op.equals("W")){
                dy=-1;
            }else if(op.equals("E")){
                dy=1;
            }
            
            int tempRow = curRow;
            int tempCol = curCol;
            boolean isCheck = true;
            
            for(int i=0;i<n;i++){
                tempRow += dx;
                tempCol += dy;
                
                if(!isRange(tempRow,tempCol,row,col) || grid[tempRow][tempCol]=='X'){
                    isCheck = false;
                }
            }
            if(isCheck){
                curRow = tempRow;
                curCol = tempCol;
                
            }

  
            
        }
        answer[0] = curRow;
        answer[1] = curCol;
        
       
        return answer;
    }
    private static boolean isRange(int x,int y,int row, int col){
        return (x>=0 && x<row && y>=0 && y<col);
        
    }
    
}
