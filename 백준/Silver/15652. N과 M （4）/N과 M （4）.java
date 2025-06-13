

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        //뽑을 때 오름차순으로 뽑아야함.
        dfs(0,1);
        System.out.print(sb); // 한 번에 출력

    }
    private static void dfs(int depth, int start) {
        if (depth == M) {
            for(int i=0;i<M;i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        //뽑을 때 오름차순으로 뽑아야함.
        //중복으로 뽑을 수 있음.
        for (int i = start; i <= N; i++) {
            nums[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
