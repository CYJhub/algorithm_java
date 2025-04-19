

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    절댓값이 가장 작은 수를 출력
    절댓값이 같을 땐 실제로 더 작은 수를 출력

    x=0이라면 절댓값을 출력
    0이 아니라면 값을 넣기

    비어있는데 0이 나오면 0을 출력
     */
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if(absA != absB){
                return absA - absB;//절댓값 기준 오름차순
            }else{
                return a - b;//원래값 기준 오름차순
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x!=0){
                pq.offer(x);

            }
            else{
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());

                }
            }
        }


    }
}
