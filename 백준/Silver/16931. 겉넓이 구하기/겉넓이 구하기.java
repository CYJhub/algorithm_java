

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] block;
    static int[] dx = {-1, 0, 1, 0};
    static int[]dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//행
        M = Integer.parseInt(st.nextToken());//열
        
        block = new int[N][M];

        //블록 채우기
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0;j< arr.length;j++){
                block[i][j] = Integer.parseInt(arr[j]);
            }
        }
        //기본적으로 옆에 붙어있는 블록이 없다면 겉넓이++(범위 벗어나는거)
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int num = block[i][j];//각 위치에 놓여진 블록의 수
                cnt += 2;//북쪽 남쪽은 항상 추가
                //상하좌우
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isScope(nx,ny)){//범위 내에 없다면
                        cnt += num;//블록수만큼 증가

                    }
                    else{
                        if(block[nx][ny]<block[i][j]){
                            cnt+=(block[i][j]-block[nx][ny]);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
    private static boolean isScope(int i,int j){
        return i>=0 && i<N && j>=0 && j<M;
    }
}
