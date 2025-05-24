
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//테스트 케이스 수
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            M = Integer.parseInt(arr[0]);//가로길이
            N = Integer.parseInt(arr[1]);//세로길이
            int K = Integer.parseInt(arr[2]);//배추 위치의 개수

            map = new int[M][N];//배추밭의 크기
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++){
                String line = br.readLine();
                String[] loc = line.split(" ");
                int x = Integer.parseInt(loc[0]);
                int y = Integer.parseInt(loc[1]);
                map[x][y] = 1;//배추 표시
            }
            int cnt=0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int x, int y){

        visited[x][y] = true;//방문 표시
        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];

            if(isRange(newX, newY)){
                if(map[newX][newY] == 1 && !visited[newX][newY]){
                    dfs(newX,newY);
                }
            }

        }
    }
    public static boolean isRange(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }

}
