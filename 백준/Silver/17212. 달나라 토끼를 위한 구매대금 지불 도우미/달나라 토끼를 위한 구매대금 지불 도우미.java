import java.util.*;

public class Main {
    /*
    1원, 2원, 5원, 7원
    제일 큰 7원부터 채워가면서 지불 금액을 채운다 -> 그리디 방식을 쓰면 틀림
    dp: 큰 문제를 해결하기 위해 작은 문제들을 해결해두고, 그것을 사용해서 큰 문제를 만드는 방식이다.
    dp[i]는 i원을 최소 몇개의 동전으로 만들 수 있는지 저장하는 값
    dp[4]=2라면 4는 2개의 동전으로 만들 수 있다는 뜻

     */
    static int N;
    static int[] coins = {1,2,5,7};
    static int[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int cnt = 0;

        // dp에 있는 값은 각 값을 만들 수 있는 최소 방법의 수
        dp = new int[N+1];//배열의 인덱스는 0부터 시작하므로 이를 1부터 시작하는 것으로 사용하기 위해서
        Arrays.fill(dp,Integer.MAX_VALUE);//비교용으로 큰 값으로 채움

        dp[0]=0;//0은 항상 0개로 만들 수 있으니

        for(int i=1;i<=N;i++){//결국 N원이 얼마의 동전으로 표현될 수 있느냐를 따져야하기 때문에 처음부터 차례로 i원을 구성
            for(int coin:coins){//총 4개의 동전을 하나씩 확인
                //지금 동전을 뺄 수 있는지 확인 && 그 금액을 만드는 방법이 있었던 경우에만 실행
                //i-coin이 이미 최솟값으로 만들어져 있다면 i는 coin을 더하면 된다.
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);//근데 여기서 dp[i]는 항상 max값 아닌가?
                    //아니지 coin을 돌면서 만약 앞에 있는 동전으로 최솟값을 만들 수 있다면 max가 아니겠지.
                }
            }
        }

        System.out.println(dp[N]);
    }
}
