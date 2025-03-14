import java.io.*;
import java.util.*;

public class Main {
    /*
    심장이 위치한 행의 번호와 열의 번호를 공백으로 구분해서 출력하고,
    두번째줄에는 왼쪽팔, 오른팔, 허리, 왼쪽 다리, 오른 다리의 길이를 공백으로 구분해서 출력
     */
    static int N;//정사각형의 변의 길이
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        // 제일 먼저 만나는 *이 머리 -> 심장은 (행+1,열)
        boolean head = false;
        int x=0;int y=0;//심장좌표
        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(!head&&input.contains("*")){
                head=true;//머리 찾음.
                x = i+1;//심장은 머리보다 한칸 아래에 있음.
                y = input.indexOf("*");
            }
            String[] split = input.split("");
            arr[i] = split;

        }
        int leftArm = countLeftArm(x,y);
        int rightArm = countRightArm(x,y);
        int body = countBody(x,y);
        int leftLeg = countLeftLeg(x,y,body);
        int rightLeg = countRightLeg(x,y,body);

        System.out.println((x+1)+" "+(y+1));
        System.out.println(leftArm+" "+rightArm+" "+body+" "+leftLeg+" "+rightLeg);

    }
    //왼쪽팔은 행은 그대로고 열이 감소하는 쪽
    //심장바로 옆부터 시작
    private static int countLeftArm(int x,int y){
        int cnt=0;
        int i=1;
        while(y-i>=0&&arr[x][y-i].equals("*")){
            cnt++;
            i++;
        }
        return cnt;
    }
    //오른쪽 팔은 행은 그대로고 열이 증가하는 쪽
    //심장바로 옆부터 시작
    private static int countRightArm(int x,int y){
        int cnt=0;
        int i=1;
        while(y+i<N&&arr[x][y+i].equals("*")){
            cnt++;
            i++;
        }
        return cnt;
    }
    //심장바로 아래에서 부터 시작
    //열은 그대로고 행이 증가하는 방향
    private static int countBody(int x,int y){
        int cnt=0;
        int i=1;
        while(x+i<N&&arr[x+i][y].equals("*")){
            cnt++;
            i++;
        }
        return cnt;

    }
    //심장 기준으로 행+1,열-1 부터 시작해서
    //열은 그대로 행이 증가하는 방향
    private static int countLeftLeg(int x,int y,int body){
        int cnt=0;
        x += body+1;
        y -= 1;
        if(x<N&&y>=0&&arr[x][y].equals("*")){
            cnt++;
            int i=1;
            while(x+i<N&&arr[x+i][y].equals("*")){
                cnt++;
                i++;
            }
        }
        return cnt;
    }
    //심장 기준으로 행+1,열+1 부터 시작해서
    //열은 그대로 행이 증가하는 방향
    private static int countRightLeg(int x,int y, int body){
        int cnt=0;
        x += body+1;
        y += 1;
        if(x<N&&y<N&&arr[x][y].equals("*")){
            cnt++;
            int i=1;
            while(x+i<N&&arr[x+i][y].equals("*")){
                cnt++;
                i++;
            }
        }
        return cnt;
    }
}
