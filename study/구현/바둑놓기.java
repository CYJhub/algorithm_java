public class 바둑놓기 {

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    private static int[][] countBlack(String[][] board) {
        int[][] result = new int[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(!board[i][j].equals(".")) {
                    result[i][j] = 0;//이미 바둑이 놓여있는 곳에는 바둑을 새로 둘 수 없음.
                    continue;
                }

                //8가지 방향으로 돌면서 조건 만족하는지 체크
                int total = 0;//총 교체되는 흑돌의 개수
                for(int k = 0; k < 8; k++) {
                    int nextX = i+directions[k][0];//그 다음x좌표
                    int nextY = j+directions[k][1];//그 다음y좌표
                    int cnt = 0;//각 방항별 교체되는 흑돌의 개수

                    if(isRange(nextX, nextY) && board[nextX][nextY].equals("B")) {
                        while(isRange(nextX, nextY) && board[nextX][nextY].equals("B")) {
                            cnt++;
                            nextX += directions[k][0];
                            nextY += directions[k][1];


                        }
                        if(isRange(nextX, nextY) && board[nextX][nextY].equals("W")) {
                            total += cnt;
                        }

                    }


                }
                result[i][j] = total;
            }
        }

        return result;

    }

    private static boolean isRange(int x,int y){
        return (x>=0 && x<8 && y>=0 && y<8);
    }
    public static void main(String[] args) {
        String[][] board = {
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "B", ".", ".", ".", "."},
                {".", ".", "W", "B", ".", ".", ".", "."},
                {".", ".", ".", "B", "W", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."}
        };

        int[][] result = countBlack(board);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
