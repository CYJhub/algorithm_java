import java.io.*;
import java.util.*;

public class Main {
    /*
    자식의 몸통 색은 아빠의 몸통색 or 꼬리색, 엄마의 몸통색 or 꼬리색 중 하나
    자식의 꼬리 색도 마찬가지
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dad = br.readLine().split(" ");
        String[] mom = br.readLine().split(" ");

        Set<String> color = new HashSet<>();//중복을 허용하지 않은 채로 색 추가

        color.add(dad[0]);
        color.add(dad[1]);
        color.add(mom[0]);
        color.add(mom[1]);
        int N = color.size();
        String[] arr = new String[N*N];

        List<String> lst = new ArrayList<>(color);
        for(int i=0;i<lst.size();i++){
            for(int j=0;j<lst.size();j++){
                StringBuilder sb = new StringBuilder();
                sb.append(lst.get(i));
                sb.append(" ");
                sb.append(lst.get(j));
                arr[i*N+j] = sb.toString();
                //System.out.println(lst.get(i)+" "+lst.get(j));
            }
        }
        Arrays.sort(arr);
        for(String s:arr){
            System.out.println(s);
        }

    }
}