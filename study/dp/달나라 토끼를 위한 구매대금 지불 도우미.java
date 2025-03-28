package dp;

import java.util.*;

public class dal {
    /*
    다이나믹 프로그래밍을 이용해서 주어진 화폐를 구성하는 최소의 동전의 개수를 구하기
    dp는 항상 구하려는 n값의 n+1만큼 배열을 생성해준다. 그리고 min으로 최솟값을 선택하면서 진행
     */
    static int N;
    static int[] dp;//여기의 각 인덱스에 들어갈 수는 i를 지불하기 위해 내야한느 최소의 동전 개수
    static int[] coins = {1,2,5,7};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//지불해야하는 금액

        dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);//최솟값을 찾아야 하므로 최대 정수를 넣어줌.
        dp[0] = 0;

        for(int i=1;i<=N;i++){
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
