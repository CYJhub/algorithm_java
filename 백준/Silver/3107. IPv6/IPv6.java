import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    출력 결과는 항상 4자리씩 끊은 마디가 8개인 구조
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = s.split(":",-1);
        //::1 이면 "","","1"

        int cnt=0;
        //숫자가 적혀있는(즉, 0이 아닌 그룹세기)
        for(int i=0;i<arr.length;i++){
            if(!arr[i].isEmpty()){
                cnt++;
            }
        }
        //System.out.println(cnt);

        int zero = 8-cnt;//0000으로 채워야 하는 그룹의 개수

        //for문 돌다가 ""를 만나면 zero만큼 의 그룹을 0000으로 채워주면됨


        int num = 0;//그룹 번호
        boolean flag = true;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("")){
                if(flag){
                    for(int j=0;j<zero;j++){
                        sb.append("0000");
                        num++;
                        if(num<8){
                            sb.append(":");
                        }

                    }
                    flag=false;
                }
                
            }
            else{
                if(arr[i].length()<4){
                    while(arr[i].length()<4){
                        arr[i]="0"+arr[i];
                    }
                    sb.append(arr[i]);
                    num++;
                }
                else if(arr[i].length()==4){
                    sb.append(arr[i]);
                    num++;
                }
                if(num<8){
                    sb.append(":");
                }
            }

        }
        System.out.println(sb);




    }
}
