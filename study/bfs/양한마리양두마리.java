package bfs;

import java.io.*;
import java.util.*;

public class boj11123_양한마리양두마리 {
    static int H;
    static int W;
    static char[][] land;
    static boolean[][] visited;

    static int count;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이
            W = Integer.parseInt(st.nextToken()); // 너비

            land = new char[H][W];
            visited = new boolean[H][W];

            for(int j=0; j<H; j++){
                land[j] = br.readLine().toCharArray();
            }
            count=0;
            for(int j=0; j<H; j++){
                for(int k=0; k<W; k++){
                    if(!visited[j][k] && land[j][k]=='#'){
                        bfs(j,k);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
    private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();//반환 후 제거

            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0<=nx&&nx<H&&0<=ny&&ny<W&&!visited[nx][ny]){
                    if(land[nx][ny]=='#'){
                        queue.offer(new Point(nx,ny));
                    }
                    visited[nx][ny] = true;

                }
            }
        }
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
