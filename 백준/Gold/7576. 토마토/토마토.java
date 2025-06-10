

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] tomatoes;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j]==1){
                    queue.add(new int[]{i,j});//익은 토마토 저장
                }
            }
        }
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            for(int[] d : directions){
                int nx = x + d[0];
                int ny = y + d[1];
                if(isRange(nx,ny) && tomatoes[nx][ny]==0){
                    queue.add(new int[]{nx,ny});
                    tomatoes[nx][ny]=tomatoes[x][y] + 1;//익음 표시
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
    private static boolean isRange(int i,int j){
        return i>=0 && i<N && j>=0 && j<M;
    }

}
