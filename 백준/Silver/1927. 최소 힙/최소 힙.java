import java.util.*;
import java.io.*;

public class Main {
    /*
    x가 자연수라면 배열에 추가
    x가 0이라면 배열에서 가장 작은 값을 출력하고 제거
    x는 2**31보다 작은 자연수 또는 0이므로 int 타입 가능

    만약, 열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
     */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()){
                    System.out.println(0);//비어있는데 출력하라고 하면 0출력
                }else{
                    int min = pq.poll();//제일 앞에 있는 수 = 가장 작은 값 제거
                    System.out.println(min);
                }
            }
            else if (x>=1){
                pq.add(x);
            }
        }
    }
}
