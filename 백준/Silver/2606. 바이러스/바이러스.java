

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*
    세로는 컴퓨터의 번호
    가로는 해당 컴퓨터에 연결된 컴퓨터의 번호
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//컴퓨터의 개수
        int M = Integer.parseInt(br.readLine());//쌍의 개수

        int[][] computers = new int[N+1][N+1];//초기 상태는 모두 0

        boolean[] visited = new boolean[N+1];//방문 여부 체크

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            String[] arr = line.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            //양방향 저장
            computers[a][b] = 1;
            computers[b][a] = 1;
        }
        int cnt = 0;
        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();


            for(int i=1;i<=N;i++){
                if(computers[cur][i]==1 && !visited[i]){
                    queue.add(i);//그에 연결된 컴퓨터를 넣기
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
