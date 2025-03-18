import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        char alice  = br.readLine().charAt(0);
        int count = 0;
        for(int i=0;i<N;i++){
            if(arr[i]==alice){
                count++;
            }
        }
        System.out.println(count);
    }
}
