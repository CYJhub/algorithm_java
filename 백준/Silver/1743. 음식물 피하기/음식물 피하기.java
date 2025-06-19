import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            arr[row-1][col-1] = 1;//음식물 표시

        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]==1 && !visited[i][j]){
                    max  = Math.max(max,bfs(i,j));
                }
            }
        }
        System.out.println(max);

    }
    private static int bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        int count = 1;
        visited[row][col] = true;//방문 표시

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int[] d : directions){
                int nx = x+d[0];
                int ny = y+d[1];

                if(isRange(nx,ny) && arr[nx][ny]==1 && !visited[nx][ny]){
                    count++;
                    visited[nx][ny] = true;
                    q.add(new Point(nx,ny));
                }
            }

        }


        return count;
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static boolean isRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
