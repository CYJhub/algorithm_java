

import java.io.*;
import java.util.*;

public class Main {
    /*
    F: 한 눈금 앞으로
    B: 한 눈금 뒤로
    L: 왼쪽으로 90도 회전
    R: 오른쪽으로 90도 회전
    거북이가 지나간 영역을 모두 포함하는 가장 작은 직사각형 넓이
     */
    static int N;
    // 북, 동, 남, 서 -> 이 방향의 순서를 처음부터 잘 배치하여, 방향을 바꿀 때 어떻게 처리하느냐가 관건인 문제였다.
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            move(s);

        }
       

    }
    private static void move(String[] str){
        //넓이 반환
        int nowx = 0, nowy = 0;

        int minX = 0, maxX = 0, minY = 0, maxY = 0;

        int dir=0;
        for(String s:str){
            if(s.equals("F")){
                nowx = nowx + dx[dir];
                nowy = nowy + dy[dir];
            }
            else if(s.equals("B")){
                nowx = nowx - dx[dir];
                nowy = nowy - dy[dir];
            }
            else if(s.equals("R")){
                dir = (dir+1) % 4;
            }
            else if(s.equals("L")){
                dir = (dir+3) % 4;
            }
            minX = Math.min(minX, nowx);
            maxX = Math.max(maxX, nowx);
            minY = Math.min(minY, nowy);
            maxY = Math.max(maxY, nowy);

        }
        int wid = maxX - minX;
        int hig = maxY - minY;

        System.out.println(wid*hig);

    }


}
