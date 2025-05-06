import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
    N:행
    M:열
    1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
    토마토 농장에 0이 있으면 안됨

    여러 곳에서 동시에 병렬적으로 토마로가 익을 수 있잖아.
    그럼 맨 처음에 1인 곳을 다 저장해. 그걸 큐에 집어넣어.
     */
    static int N;
    static int M;
    static int[][] tomatoes;
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static List<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        Queue<Point> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                int x = Integer.parseInt(arr[j]);
                tomatoes[i][j] = x;
                if(x==1){
                    queue.add(new Point(i,j));//익은 토마토가 있는 위치를 따로 저장->여기서부터 시작
                }
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();


            for(int[] dir : directions){
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if(isRange(nx,ny) && tomatoes[nx][ny]==0){
                    tomatoes[nx][ny] = tomatoes[p.x][p.y] + 1;//날짜 증가
                    queue.add(new Point(nx,ny));
                }
            }

        }
        //다 돌았는데도 0이 남아있으면 -1출력

        int day=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomatoes[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                if(tomatoes[i][j]>day){
                    day=tomatoes[i][j];
                }
            }
        }
        System.out.println(day-1);


    }
    public static boolean existZero(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomatoes[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<M;
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
