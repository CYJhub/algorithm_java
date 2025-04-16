

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dir = new int[6];
        int[] len = new int[6];

        for(int i = 0; i < 6; i++){
            String[] input = br.readLine().split(" ");
            dir[i] = Integer.parseInt(input[0]);
            len[i] = Integer.parseInt(input[1]);
        }

        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIndex = -1;
        int maxHeightIndex = -1;

        for(int i = 0; i < 6; i++){
            if(dir[i] ==1 || dir[i]==2){
                if(len[i]>maxWidth){
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }
            }else{
                if(len[i]>maxHeight){
                    maxHeight = len[i];
                    maxHeightIndex = i;
                }
            }
        }

        // 큰 사각형 면적
        int bigArea = maxWidth * maxHeight;
        int smallArea = 0;
        // 연속된 두 변이 maxWidth, maxHeight인 구간을 찾기
        for (int i = 0; i < 6; i++) {
            int cur = len[i];
            int next = len[(i + 1) % 6];

            if ((cur == maxWidth && next == maxHeight) || (cur == maxHeight && next == maxWidth)) {
                // 그 다음 두 변이 작은 사각형
                int sw = len[(i + 3) % 6];
                int sh = len[(i + 4) % 6];
                smallArea = sw * sh;
                break;
            }
        }
        System.out.println((bigArea - smallArea) * N);
    }
}
