

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /*
    사탕의 색이 다른 인접한 두 칸을 "한 번" 고른 다음,
    두 칸을 서로 교환

    모두 같은 색으로 이루어져 있는 가장 긴 연속 부분을 고름

    빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y

    1. 인접한 칸(오른쪽, 아래)을 하나 선택해서 사탕을 바꾼다.
    2. 바꾼 보드에서 가장 긴 연속 사탕을 계산
    3. 최댓값 갱신
    4. 원상 복구
     */
    static int N;
    static char[][] candy;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        candy = new char[N][N];//한 문자 단위로 작업하기 때문에

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                candy[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                //좌우
                swap(i,j-1,i,j);
                maxNum();
                swap(i,j,i,j-1);

                //상하
                swap(j-1,i,j,i);
                maxNum();
                swap(j,i,j-1,i);
            }
        }

        System.out.println(max);


    }
    //2차원 배열의 두개의 좌표(4개)를 받아 위치 바꾸기
    private static void swap(int r1,int c1,int r2,int c2){
        char temp = candy[r1][c1];
        candy[r1][c1] = candy[r2][c2];
        candy[r2][c2] = temp;
    }
    // 가장 긴 사탕 배열 찾기
    private static void maxNum(){
        int cnt = 0;

        for(int i=0;i<N;i++){
            int rowCnt = 1, colCnt = 1;
            for(int j=1;j<N;j++){
                //행 기준
                if(candy[i][j-1] == candy[i][j]){
                    rowCnt++;
                }else{
                    rowCnt=1;
                }
                max = Math.max(rowCnt,max);

                //열 기준
                if(candy[j-1][i] == candy[j][i]){
                    colCnt++;
                }else{
                    colCnt=1;
                }
                max = Math.max(colCnt,max);
            }
        }
    }
}
