import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N]; //길이가 N짜리인 정수형 배열을 생성
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();// 현재 수열의 값
        }
        
        StringBuffer bf = new StringBuffer();
        int num = 1;//비교할 자연수
        boolean result = true;
        for(int i=0;i<N;i++){
            if(A[i]>=num){
                while(num<=A[i]){
                    st.push(num);//스택에 추가
                    bf.append("+\n");
                    num++;//자연수를 1씩 증가
                }
                st.pop();
                bf.append("-\n");
            }
            else{//현재 수열의 값보다 자연수가 크면
                int n = st.pop();
                if(n>A[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        if(result)System.out.println(bf.toString());
    }
}