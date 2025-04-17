

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<Integer> pos = new ArrayList<>();

        for(int i=0;i<K+1;i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(dir == 1){
                pos.add(len);
            }else if(dir == 2){
                pos.add(2*W+H-len);
            }else if(dir == 3){//4
                pos.add(2*W+2*H-len);
            }else if(dir == 4){
                pos.add(W+len);
            }
        }
        int myPos = pos.get(pos.size()-1);
        int answer = 0;
        for(int i=0;i<pos.size();i++){
            int d1 = Math.abs(myPos-pos.get(i));
            int max = Math.max(myPos, pos.get(i));
            int min = Math.min(myPos, pos.get(i));
            answer += Math.min(d1,(2*H+2*W-max) + min);
        }
        System.out.println(answer);
    }
}
