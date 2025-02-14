class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int width = park[0].length();  // 가로 크기
        int height = park.length;  // 세로 크기

        int[][] grid = new int[height][width];
        
        // 시작점
        int row=0;
        int col=0;
        
        // 공원 순회하며 2차원 그리드 채우기
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(park[i].charAt(j) == 'S'){ // 시작점
                    grid[i][j] = -1;
                    row=i;
                    col=j;
                }
                else if(park[i].charAt(j) == 'O'){ // 길
                    grid[i][j] = 0;
                }
                else if(park[i].charAt(j) == 'X'){ // 장애물 
                    grid[i][j] = 1;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            String[] route = routes[i].split(" ");
            String dir = route[0]; // 방향
            int num = Integer.parseInt(route[1]); // 움직일 거리
            
            int newRow = row, newCol = col;
            
            // 한 칸씩 이동하며 장애물 & 범위 초과 검사
            boolean isBlocked = false;
            for(int j=1;j<=num;j++){
                if(dir.equals("N")) newRow = row - j;
                else if(dir.equals("S")) newRow = row + j;
                else if(dir.equals("W")) newCol = col - j;
                else if(dir.equals("E")) newCol = col + j;
                
                if(isOutOfBounds(newRow, newCol, height, width) || grid[newRow][newCol] ==1){
                    isBlocked = true;
                    break;
                }
                
            }
            if (!isBlocked) {
                if (dir.equals("N")) row -= num;
                else if (dir.equals("S")) row += num;
                else if (dir.equals("W")) col -= num;
                else if (dir.equals("E")) col += num;
            }
            
        }
        answer[0] = row;
        answer[1] = col;
        return answer;
    }
    
    // 공원을 벗어나는지
    public boolean isOutOfBounds(int row,int col,int height,int width){
        boolean flag = false;
        if(row<0||row>height-1 || col<0|| col>width-1){
            flag = true;
        }
        return flag;
    }
    
    // // 장애물을 만나는지
    // public boolean hasObstacle(int[][] grid, int row, int col){
    //     boolean flag = false;
    //     if(grid[row][col] == 1){
    //         flag = true;
    //     }
    //     return flag;
    // }
}
//2차원의 그리드를 만든다.
//각 그리드에 시작점, 길, 장애물을 표시한다.
//시작점의 인덱스를 알아내자.
//라우트의 개수만큼 돌며, 방향 키와 개수를 파악하되 공원을 벗어나는지, 장애물을 만나는지 확인!
// 시작점=-1, 길=0, 장애물=1