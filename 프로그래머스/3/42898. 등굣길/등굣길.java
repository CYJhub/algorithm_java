import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        
        int[][] dp = new int[n+1][m+1];

        for(int[] p:puddles){
            dp[p[1]][p[0]] = -1;//물 웅덩이 표시
        }
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j]==-1) continue;
                if(dp[i-1][j]>0){
                    dp[i][j] += dp[i-1][j] % mod;
                }
                if(dp[i][j-1]>0){
                    dp[i][j] += dp[i][j-1] % mod;
                }
            }
            
        }
    
        return dp[n][m] % mod;
    }

}
