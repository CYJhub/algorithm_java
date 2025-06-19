import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    count = 1;
                    dfs(i,j);
                    max = Math.max(max,count);
                }
            }
        }
        System.out.println(max);

    }
    private static int dfs(int x, int y) {
        visited[x][y] = true;

        for(int[] d : directions){
            int nx=x+d[0];
            int ny=y+d[1];

            if(isRange(nx,ny)){
                if(!visited[nx][ny] && arr[nx][ny]==1){
                    count++;
                    dfs(nx,ny);
                }
            }
        }

        return count;

    }
    private static boolean isRange(int i, int j) {
        return i>=0 && i<N && j>=0 && j<M;
    }
}
