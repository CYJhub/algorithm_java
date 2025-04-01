package dp;

import java.util.*;

public class boj1463_1로만들기 {
    /*
    1. N%3==0
    2. N%2==0
    3. -1
     */
    static int N;
    static int[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=0;

        //저 세개의 연산을 순서없이 배치해야함
        for(int i=1;i<=N;i++){
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            dp[i] = Math.min(dp[i],dp[i-1]+1);
        }
        System.out.println(dp[N]);
    }
}
