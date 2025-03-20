import java.util.*;
import java.io.*;

public class Main {
    static int h;
    static int w;
    static int[][] grid;
    static boolean[][] visited;
    static int count;
    /*
    대각선까지 고려해야함.
    상하좌우
     */
    static int[] dx = {-1,1,0,0, -1,-1,1,1};
    static int[] dy = {0,0,-1,1 ,1,-1,1,-1};
    static List<Integer> result  = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            count=0;
            //w,h
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0&&h==0)break;

            grid = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++){// 0 0
                String[] str = br.readLine().split(" ");
                for(int j=0;j<str.length;j++){
                    grid[i][j] = Integer.parseInt(str[j]);
                }

            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(grid[i][j]==1 && !visited[i][j]){
                        count++;
                        bfs(i,j);
                    }
                }
            }
            result.add(count);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }


    }
    private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));

        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0;i<8;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0<=nx && nx<h && 0<=ny && ny<w && !visited[nx][ny] && grid[nx][ny]==1){
                    queue.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }

            }
        }
    }
    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
