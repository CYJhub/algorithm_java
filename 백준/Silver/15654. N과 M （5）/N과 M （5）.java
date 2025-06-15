import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 자연수 중에서 M개를 고른 수열
     */
    static int N, M;
    static int[] nums;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//N개의 자연수는 모두 다른 수이다.
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        answer = new int[M];//조건을 만족하는 길이가 M인 수열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);//오름차순 정렬

        dfs(0);

        System.out.println(sb);


    }
    private static void dfs(int depth) {
        if (depth == M) {
            for(int i=0;i<M;i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(nums[i]!=0){
                answer[depth] = nums[i];
                nums[i] = 0;//사용 표시
                dfs(depth+1);
                nums[i] = answer[depth];//원상 복귀
            }
        }
    }
}
