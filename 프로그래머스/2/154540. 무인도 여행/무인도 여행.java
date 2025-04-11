import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int row = maps.length;
        int col = maps[0].length();
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[row][col];//방문 여부 표시, 초반에는 false로 초기화
        int cnt = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && maps[i].charAt(j)!='X'){//아직 방문하지 않았고 바다가 아니라면
                    int num = bfs(i,j,row,col,visited,maps);
                    //섬의 개수 카운드하고 식량의 개수 카운트해서 넣어줌
                    cnt++;
                    answer.add(num);
                }
            }
        }
        //System.out.println(cnt);
        if(cnt==0){
            int[] no = new int[1];
            no[0] = -1;
            return no;
        }
        int[] result = answer.stream().mapToInt(x->x).toArray();
        Arrays.sort(result);
        
        
        return result;
    }
    private static int bfs(int x, int y,int row, int col,boolean[][] visited,String[] maps){
        int food = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;
        food += maps[x].charAt(y)-'0';
        
        while(!queue.isEmpty()){
            Point p = queue.poll();//반환 후 제거
            
            for(int i=0;i<4;i++){
                //다음 위치, 상하좌우
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(0<=nx && nx<row && 0<=ny && ny<col && !visited[nx][ny]){
                    if(maps[nx].charAt(ny)!='X'){
                        queue.offer(new Point(nx,ny));
                        food += maps[nx].charAt(ny)-'0';
                        
                    }
                    visited[nx][ny] = true;
                }
            }
        }
        //System.out.println(food);
        return food;
    }
    public static class Point{
        public int x;
        public int y;
        
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}

//각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 
//dfs 혹은 bfs로 섬의 개수를 세며, 그 섬에 있는 숫자들을 모두 더해서 반환