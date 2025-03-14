import java.util.Scanner;

public class Main {
    /*
    상근이가 먼저 게임
    N=1 상근이 1개
    N=2 상근 1개, 창영 1개
    N=3 상근 1개, 창영 1개, 상근 1개
        상근 3개
    N=4 상근 3개 창영 1개
        상근 1, 창영 1, 상근 1, 창영 1
    N=5 상근 1개 창영 3개 상근 1개
        상근 3개 창영 1개 상근 1개
    N=6 상근 1개 ... 창영 1개
        상근 3개 창영1, 상근 1, 창영 1
                창영3

    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N%2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}
