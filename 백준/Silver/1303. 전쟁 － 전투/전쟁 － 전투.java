
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        List<Integer> white = new ArrayList<>();
        List<Integer> black = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'W') {
                    white.add(bfs(i,j,'W'));
                }else if (map[i][j] == 'B') {
                    black.add(bfs(i,j,'B'));
                }
            }
        }
        int wcnt=0;
        int bcnt=0;
        for(int i=0;i<white.size();i++){
            wcnt += (white.get(i)*white.get(i));
        }
        for(int i=0;i<black.size();i++){
            bcnt += (black.get(i)*black.get(i));
        }
        System.out.println(wcnt+" "+bcnt);


    }
    private static int bfs(int x, int y, char color) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = 'V'; // 방문 표시
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            for (int[] d : direction) {
                int nx = x1 + d[0];
                int ny = y1 + d[1];

                if(isRange(nx, ny) && map[nx][ny] == color) {
                    q.add(new int[]{nx, ny});
                    map[nx][ny] = 'V'; // 방문 처리
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean isRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
