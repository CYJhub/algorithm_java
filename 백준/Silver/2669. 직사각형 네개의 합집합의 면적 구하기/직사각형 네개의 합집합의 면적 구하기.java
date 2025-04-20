

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            for(int j=a1+1;j<=a2;j++){
                for(int k=b1+1;k<=b2;k++){
                    map[j][k] = 1;
                }
            }
        }
        int cnt =0;
        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++){
                if(map[i][j]==1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}
