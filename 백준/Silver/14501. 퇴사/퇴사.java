

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] schedule;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        schedule = new int[N][2];

        dp = new int[N+2];
        Arrays.fill(dp,0);//최댓값을 찾아야 하므로
        //dp[0] = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            schedule[i][0] = t;
            schedule[i][1] = p;
        }

        for (int i = 1; i <= N; i++) {
            int time = schedule[i-1][0];
            int pay = schedule[i-1][1];

            dp[i+1] = Math.max(dp[i+1],dp[i]);//현재까지의 최대 수익 저장하기

            if(i+time<=N+1){
                dp[i+time] = Math.max(dp[i+time],dp[i]+pay);
            }


        }

        int max = 0;
        for (int i = 1; i <= N+1; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);



    }
}
