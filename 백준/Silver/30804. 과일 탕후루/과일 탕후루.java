

import java.util.*;
import java.io.*;

public class Main {
    /*
    앞에서 빼고, 뒤에서 빼고
    서로 다른 과일의 개수를 알아야 하는 것이 관건이다.
    제외할 때마다 set를 생성해 사이즈를 재는 것은 시간초과 발생! -> 투포인터 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> fruitCnt = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for(int rigth = 0;rigth < N;rigth++){
            fruitCnt.put(fruits[rigth],fruitCnt.getOrDefault(fruits[rigth],0)+1);

            while(fruitCnt.size()>2){//과일 종류가 2가지보다 많으면 left를 이동해주면서 맞춰줌

                fruitCnt.put(fruits[left],fruitCnt.get(fruits[left])-1);
                if(fruitCnt.get(fruits[left])==0){
                    fruitCnt.remove(fruits[left]);
                }
                left++;

            }
            maxLength = Math.max(rigth - left +1,maxLength);
        }
        System.out.println(maxLength);


    }
}
