import java.util.*;

public class Main {
    /*
    주어진 N을 3,5를 이용해 최소로 나타낼 수 있어야 한다.
     */
    static int N;
    static int[] dp;
    static int[] kilos = {3,5};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1;i<=N;i++){
            for(int k:kilos){
                if(i-k>=0&&dp[i-k]!=Integer.MAX_VALUE){
                    dp[i] =  Math.min(dp[i],dp[i-k]+1);
                }
            }
        }
        if(dp[N]==Integer.MAX_VALUE){
            dp[N] = -1;
        }
        System.out.println(dp[N]);
    }
}
