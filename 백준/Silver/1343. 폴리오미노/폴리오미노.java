

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    AAAA BB로 나누기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        boolean flag = true;

        if(s.contains("XXXX")){
            s = s.replaceAll("XXXX", "AAAA");
        }
        if(s.contains("XX")){
            s = s.replaceAll("XX", "BB");
        }
        if(s.contains("X")){
            flag = false;
        }
        if(flag){
            System.out.println(s);
        }
        else{
            System.out.println(-1);
        }

    }
}
