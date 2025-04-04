

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    단지 인접한 차들만이 아닌 뒤에 있는 차량중에 자신보다 순서가 낮은 차량을 탐색
     */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();//<차번호: 들어온 순서>

        for(int i=1;i<=N;i++){
            String s = br.readLine();
            map.put(s,i);
        }

        int[] out = new int[N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            out[i] = map.get(s);

        }
        int cnt =0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(out[i]>out[j]){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
