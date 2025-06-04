

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] tomatoes;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());//열
        N = Integer.parseInt(st.nextToken());//행

        tomatoes = new int[N][M];

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1){
                    queue.add(new Point(i, j));//익은 토마토 큐에 넣기
                }
            }
        }
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int x = p.x, y = p.y;

            for(int[] d : directions){
                int nx = x + d[0], ny = y + d[1];
                if(isRange(nx, ny) && tomatoes[nx][ny] == 0){
                    tomatoes[nx][ny] = tomatoes[x][y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        int day = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomatoes[i][j] == 0){
                     System.out.println(-1);
                     return;
                }else{
                    if(day<tomatoes[i][j]){
                        day = tomatoes[i][j];
                    }
                }
            }
        }
        System.out.println(day-1);

    }
    public static boolean isRange(int x,int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
