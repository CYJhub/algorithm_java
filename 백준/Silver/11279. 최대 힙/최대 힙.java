

import java.util.*;
import java.io.*;

public class Main {
    /*
    배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.
     */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //큰수가 우선인 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    int max = pq.poll();
                    System.out.println(max);
                }
            }else{
                pq.add(x);
            }
        }
    }
}
