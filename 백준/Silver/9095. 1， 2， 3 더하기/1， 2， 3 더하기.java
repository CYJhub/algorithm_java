import java.io.*;
import java.util.*;

public class Main {
    /*
    1,2,3의 합으로 나타냄(순서가 다르면 다른 경우로 취급)
    1=1
    2=1+1, 2
    3=1+1+1, 2+1,1+2, 3
    4=1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 1+3, 3+1, 2+2
    5=11111,1211,2111,1121,1112,113.131,311,122,221,122,212,23,32

    n을 셀 때,n-3, n-2, n-1

     */
    static int N;
    static int[] dp;
    static int[] nums;
    static Set<String> set = new HashSet<>();//수를 나타내는 고유한 연산을 저장할 셋
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];


        int max=0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            nums[i]=num;
            if(num>max){
                max = num;
            }
        }
        dp = new int[max+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<=max;i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }

        // 결과 출력
        for(int i=0;i<N;i++){
            System.out.println(dp[nums[i]]);

        }

    }
}
