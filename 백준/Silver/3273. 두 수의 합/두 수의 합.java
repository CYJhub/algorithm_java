
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int left=0;
        int right= N-1;

        int cnt=0;

        while(left < right){
            if(arr[left]+arr[right]==x) {
                cnt++;
                left++;
                right--;
            }else if(arr[left]+arr[right]<x){
                left++;
            }else if(arr[left]+arr[right]>x){
                right--;
            }
        }

        System.out.println(cnt);

    }
}
