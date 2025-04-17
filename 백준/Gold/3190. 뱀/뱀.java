

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static Deque<Point> dq = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0,-1,0};//우하좌상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        HashMap<Integer,String> rotateInfoMap = new HashMap<>();

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] apple = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int appleX = Integer.parseInt(st.nextToken());// 지금 설정은 (1,1) 기준
            int appleY = Integer.parseInt(st.nextToken());
            map[appleX-1][appleY-1] = 1;//사과가 있음을 1로 표시
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());//초
            String C = st.nextToken();//방향

            rotateInfoMap.put(X,C);
        }
        dq.add(new Point(0,0));
        int dir=0;

        int time=1;
        while(true){
            Point p = dq.getLast();//맨 뒤에서 조회
            int nextX = p.x + dx[dir];
            int nextY = p.y + dy[dir];

            //벽을 만나거나 자기 자신과 닿으면 끝
            if(!isRange(nextX,nextY)||isInclude(nextX,nextY)) break;

            dq.add(new Point(nextX,nextY));
            if(map[nextX][nextY]!=1){
                dq.pollFirst();//몸길이 감소
            }else{
                map[nextX][nextY]=0;//사과 먹으면 사라짐
            }
            if(rotateInfoMap.containsKey(time)){
                String newDir = rotateInfoMap.get(time);//바뀔 방향
                dir = convertDir(dir,newDir);

            }
            time++;

        }
        System.out.println(time);
    }
    private static int convertDir(int dir,String newDir){
        int temp = dir;
        if (newDir.equals("D")) {
            if (temp == 3) {
                temp = 0;
            } else {
                temp++;
            }
        } else if (newDir.equals("L")) {
            if (temp == 0) {
                temp = 3;
            } else {
                temp--;
            }
        }
        return temp;
    }
    private static boolean isInclude(int x,int y){
        for(Point p:dq){
            if(p.x==x&&p.y==y){
                return true;
            }
        }
        return false;
    }
    private static boolean isRange(int x,int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
