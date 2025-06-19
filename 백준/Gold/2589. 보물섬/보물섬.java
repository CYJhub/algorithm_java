import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int maxDepth=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='L'){
                    int[][] distance = new int[N][M];
                    visited=new boolean[N][M];
                    Queue<int[]> queue = new LinkedList<>();

                    queue.add(new int[]{i,j,0});
                    visited[i][j]=true;

                    while(!queue.isEmpty()){
                        int[] arr = queue.poll();
                        int x = arr[0];
                        int y = arr[1];
                        int depth = arr[2];

                        maxDepth = Math.max(maxDepth,depth);

                        for(int[] d : directions){
                            int nx = x+d[0];
                            int ny = y+d[1];

                            if(isRange(nx,ny) && map[nx][ny]=='L' &&!visited[nx][ny]){
                                visited[nx][ny]=true;
                                queue.add(new int[]{nx,ny,depth+1});
                            }

                        }
                    }
                }
            }
        }
        System.out.println(maxDepth);


    }
    private static boolean isRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
