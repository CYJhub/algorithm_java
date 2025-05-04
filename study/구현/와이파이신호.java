import java.util.*;

public class 와이파이신호잡기 {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};//상하좌우
    public static int[] getMaxWifi(int[][] grid, int k, int[][] wifi_devices, int[][] phones) {
        int[] answer = new int[phones.length];

        int m = grid.length;//row
        int n = grid[0].length;//col
        int[][] signal = new int[m][n];

        //최솟갓으로 초기화
        for(int[] row:signal){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        //각 공유기마다 BFS수행
        for(int[] device:wifi_devices){
            int sx = device[0];
            int sy = device[1];
            int power = device[2];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sx, sy, power});

            boolean[][] visited = new boolean[m][n];//방문 여부 체크

            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int strength = curr[2];

                if (strength <= 0 || visited[x][y]) continue;
                visited[x][y] = true;

                signal[x][y] = Math.max(signal[x][y], strength);

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (isRange(nx, ny, m, n)) {
                        int nextStrength = strength - 1;
                        if (grid[nx][ny] == 1) {
                            nextStrength -= k;
                        }
                        if (nextStrength > 0 && !visited[nx][ny]) {
                            queue.offer(new int[]{nx, ny, nextStrength});
                        }
                    }
                }

            }

        }
        for(int i=0;i<phones.length;i++){
            int x = phones[i][0];
            int y = phones[i][1];

            answer[i] = (signal[x][y] == Integer.MIN_VALUE) ? 0 : signal[x][y];


        }
        return answer;
    }
    private static boolean isRange(int x,int y,int m,int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };
        int k = 2;
        int[][] wifi_devices = {
                {0, 0, 5},
                {3, 3, 4}
        };
        int[][] phones = {
                {0, 1},
                {1, 2},
                {2, 2},
                {3, 1}
        };

        int[] result = getMaxWifi(grid, k, wifi_devices, phones);
        System.out.println(Arrays.toString(result));  // 예: [4, 3, 3, 2]
    }
}
