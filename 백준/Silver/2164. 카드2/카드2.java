import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//정수를 입력받음
        Queue<Integer> q = new LinkedList<>();
        //큐에 자연수를 오름차순으로 넣어준다.
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        while(q.size()>1){
            q.poll();
            q.add(q.poll());//제거한 후 다시 넣어줌
        }
        System.out.println(q.poll());
    }
}