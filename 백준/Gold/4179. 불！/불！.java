import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    불도 번지고
    지훈이도 움직임

    맵을 두개 만들어서 비교
    불을 먼저 지핌

    지훈이는 .으로만 이동가능

     */
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 지훈이가 갈 수 있는 맵
        char[][] map = new char[R][C];
        Queue<Point> queue = new LinkedList<>();

        // 불이 번지는 맵
        char[][] fire = new char[R][C];
        Queue<Point> fireQ = new LinkedList<>();

        int[][] fireTime = new int[R][C];
        int[][] jihunTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                fire[i][j] = row.charAt(j);

                fireTime[i][j] = -1;
                jihunTime[i][j] = -1;

                if(map[i][j] == 'J'){
                    queue.add(new Point(i,j));
                    jihunTime[i][j] = 0;
                }
                else if(map[i][j] == 'F'){
                    fireQ.add(new Point(i,j));
                    fireTime[i][j] = 0;
                }
            }
        }
        while(!fireQ.isEmpty()){
            Point cur = fireQ.poll();

            for(int[] d: directions){
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if(isRange(nx,ny) && fire[nx][ny]!='#' && fireTime[nx][ny]==-1){
                    fireQ.add(new Point(nx,ny));
                    fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                }
            }
        }
        int sec = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int[] d : directions){

                int nx = p.x+d[0];
                int ny = p.y+d[1];
                if(!isRange(nx,ny)){
                    System.out.println(jihunTime[p.x][p.y]+1);
                    return;
                }else{
                    if(map[nx][ny]=='.' && jihunTime[nx][ny]==-1){
                        if(fireTime[nx][ny]==-1 || jihunTime[p.x][p.y] +1 < fireTime[nx][ny] ){
                            jihunTime[nx][ny] = jihunTime[p.x][p.y] + 1;
                            queue.add(new Point(nx,ny));
                        }
                    }
                }

            }
        }
        System.out.println("IMPOSSIBLE");


    }
    public static boolean isRange(int x,int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
