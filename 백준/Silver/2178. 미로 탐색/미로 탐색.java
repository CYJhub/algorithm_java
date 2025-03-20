import java.io.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static int[][] maze;
    static int[][] distance; // 출발지로부터의 거리
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        maze = new int[h][w];
        distance = new int[h][w];

        //미로 채우기
        for(int i=0;i<h;i++){
            String[] arr = br.readLine().split("");
            for(int j=0;j<arr.length;j++){
                maze[i][j] = Integer.parseInt(arr[j]);
                distance[i][j] = -1;//-1=방문하지 않음으로 초기화
            }
        }
        queue.offer(new Point(0, 0));
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(isRange(nx,ny) && maze[nx][ny]==1 && distance[nx][ny]==-1){
                    queue.offer(new Point(nx,ny));
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                }
            }


        }
        System.out.println(distance[h-1][w-1]);



    }
    private static boolean isRange(int x,int y){
        if(0<=x && x<h && 0<=y && y<w){
            return true;
        }
        return false;
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
