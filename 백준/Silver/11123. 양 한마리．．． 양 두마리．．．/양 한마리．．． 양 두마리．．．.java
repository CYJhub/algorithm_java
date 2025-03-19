import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; // 상 하
    static int[] dy = {0, 0, -1, 1}; // 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int[] result = new int[T];

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            int count = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#') {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            result[t] = count;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int x, int y) {
        if (x < 0 || x >= H || y < 0 || y >= W || map[x][y] == '.') return;

        map[x][y] = '.'; // 방문 처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }
}
