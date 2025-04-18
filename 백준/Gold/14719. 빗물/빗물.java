

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] height;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();//세로 길이
        int W = scan.nextInt();//가로 길이

        height = new int[W];

        for(int i = 0; i < W; i++){
            height[i] = scan.nextInt();
        }
        int result=0;
        for(int i=1;i<W-1;i++){
            int left = 0;
            int right = 0;

            for(int j=0;j<i;j++){
                left = Math.max(height[j],left);
            }
            for(int j=i+1;j<W;j++){
                right = Math.max(height[j],right);
            }
            if(height[i]<left && height[i] <right){
                result += Math.min(left,right)-height[i];
            }
        }
        System.out.println(result);

    }
}
