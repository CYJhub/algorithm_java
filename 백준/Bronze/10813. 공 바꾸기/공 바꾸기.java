import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        int temp;
        
        int[] arr = new int[a]; //원소가 a개인 배열 생성
        
        for(int i=1;i<=a;i++){
            arr[i-1] = i; // 바구니 번호와 같은 번호의 공을 넣어줌
        }
        for(int j=0;j<b;j++){ // b번 반복
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            if (num1 != num2){
                temp = arr[num1-1];
                arr[num1-1] = arr[num2-1];
                arr[num2-1] = temp;
            }
        }
        for(int k=0;k<a;k++){
            System.out.print(arr[k]+" ");
        }
    }
}