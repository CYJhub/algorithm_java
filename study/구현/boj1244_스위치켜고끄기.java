import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;//스위치 개수
    static int[] switches;//스위치 상태를 저장할 배열
    static int S;//학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        switches = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //스위치 초기 상태 저장
        for(int i=1;i<=N;i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for(int i=0;i<S;i++){
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());//학생의 성별
            int num = Integer.parseInt(st.nextToken());//학생이 가지고 있는 스위치 번호

            //학생의 성별이 남자냐 여자나에 따라서
            if(gender==1){
                male(num);
            }else{
                female(num);
            }
        }
        for(int i=1;i<=N;i++){
            System.out.print(switches[i]+" ");
            if(i%20 == 0){
                System.out.println();
            }
        }

    }

    // 스위치 번호가 자신이 받은 수의 배수이면 토글한다.
    public static void male(int n){
        int i=1;
        while(i*n<=N){
            toggle(i*n);
            i++;
        }
    }

    // 자기가 받은 수를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 토글한다.
    public static void female(int n){
        toggle(n);
        int i=1;
        while(0<n-i && n+i<=N){
            if(switches[n-i] == switches[n+i]) {
                toggle(n - i);
                toggle(n + i);
                i++;
            }else{
                break;
            }
        }
    }

    public static void toggle(int n){
        if(switches[n]==1){
            switches[n]=0;
        }else{
            switches[n]=1;
        }
    }
}
