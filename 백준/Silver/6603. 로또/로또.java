import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;//숫자 집합
    static int[] lotto = new int[6];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0){
                break;
            }
            nums = new int[N];
            for(int i=0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);//오름 차순

            dfs(0,0);//중복 없이
            sb.append("\n");


        }
        System.out.println(sb);


    }
    private static void dfs(int depth, int start){
        if(depth==6){
            for(int i=0;i<6;i++){
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++){
            lotto[depth] = nums[i];
            dfs(depth+1,i+1);

        }
    }
}
