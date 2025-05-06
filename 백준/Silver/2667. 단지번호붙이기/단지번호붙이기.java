import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        List<Integer> count = new ArrayList<>();
        //출력 count.size()와 안의 원소들

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    int cnt = bfs(i,j);
                    count.add(cnt);
                }
            }
        }
        count.sort((a,b)->a-b);
        System.out.println(count.size());
        for(int i=0;i<count.size();i++){
            System.out.println(count.get(i));
        }
    }
    public static int bfs(int x,int y){
        int cnt=1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();


            for(int[] dir : directions){
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];
                if(isRange(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;


    }
    public static boolean isRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
