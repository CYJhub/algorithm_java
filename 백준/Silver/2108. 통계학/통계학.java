import java.io.*;
import java.util.*;

public class Main {
    static int N;//수의 개수
    static int[] arr;//수들의 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(avg());
        System.out.println(middleAvg());
        System.out.println(manyAvg());
        System.out.println(range());
    }
    //산술 평균
    private static int avg(){
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        double avg = (double)sum/N;
        return (int)Math.round(avg); // 첫째자리에서 반올림
    }
    //중앙값
    private static int middleAvg(){
        Arrays.sort(arr);
        return arr[N/2];
    }
    //최빈값
    private static int manyAvg(){
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        int maxCnt=0;
        for(int i=0;i<N;i++){
            int count = map.getOrDefault(arr[i],0)+1;
            if(count>maxCnt){
                maxCnt = count;
            }
            map.put(arr[i],count);
        }
        List<Integer> lst = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxCnt){
                lst.add(entry.getKey());
            }
        }
        Collections.sort(lst);
        if(lst.size()==1){
            return lst.get(0);
        }else {
            return lst.get(1);
        }
    }
    //범위
    private static int range(){
        Arrays.sort(arr);
        return arr[N-1]-arr[0];
    }
}
