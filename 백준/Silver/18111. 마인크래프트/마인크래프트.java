import java.io.*;
import java.util.*;
public class Main {
    /*
    땅을 고르는데 걸리는 최소 시간, 땅의 높이
    1번. 좌표 위에 있는 블록을 인벤토리에 넣기 2초
    2번. 인벤토리에서 블록을 꺼내서 좌표 맨 위에 넣기 1초
     */
    static int N;
    static int M;
    static int B;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = -1;
        //그리드 채워넣기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;
                if(num<min) min = num;
                if(num>max) max = num;
            }
        }
        //어차피 그리드의 순서는 중요하지ㅣ 않음
        int time = Integer.MAX_VALUE;
        int high=0;

        for(int i=min;i<=max;i++){
            int count = 0;
            int block = B;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(grid[j][k]>i){
                        count += (grid[j][k]-i)*2;
                        block += (grid[j][k]-i);
                    }
                    else{
                        count += (i-grid[j][k]);
                        block -= (i-grid[j][k]);
                    }
                }
            }
            if(block<0)break;

            if(time>=count){
                time = count;
                high = i;

            }
        }
        System.out.println(time+" "+high);



    }

}
