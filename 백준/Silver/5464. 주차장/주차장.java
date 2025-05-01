
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    주차료 = 차량의 무게 * 책정된 단위 무게당 요금
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N+1];
        int[] cars = new int[M+1];


        for(int i=1;i<=N;i++){
            money[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=M;i++){
            cars[i] = Integer.parseInt(br.readLine());
        }

        //주차장 공간
        boolean[] full = new boolean[N+1];
        full[0] = true;

        int total = 0;

        Queue<Integer> waitQueue = new LinkedList<>();

        Map<Integer,Integer> map = new HashMap<>();//차량 번호:주차 자리

        for(int i=0;i<2*M;i++){
            int carNum = Integer.parseInt(br.readLine());

            if(carNum>0){
                boolean flag = false;
                for(int j=1;j<=N;j++){
                    if(!full[j]){
                        map.put(carNum,j);
                        full[j] = true;
                        total += cars[carNum]*money[j];
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    waitQueue.add(carNum);
                }
            }else{
                int num = (-1)*carNum;
                full[map.get(num)] = false;//비었다고 바꿈.
                int slot = map.get(num);
                map.remove(num);

                if(!waitQueue.isEmpty()){
                    int nextCar = waitQueue.poll();
                    full[slot] = true;
                    map.put(nextCar,slot);
                    total += cars[nextCar]*money[slot];
                }
            }

        }

        System.out.println(total);

    }
}
