public class islands {
    public static int numberOfIslands(char[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length ==0){
            return 0;
        }

        int numberOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row=0;row < rows; row++) {
            for (int col= 0; col< cols; col++) {
                if (grid[row][col] == '1'){
                    numberOfIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return numberOfIslands;

    }

    public static void dfs(char[][] grid, int row, int col) {
        if (row<0||row>=grid.length||col<0||col>=grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row-1,col);
        dfs(grid, row+1,col);
        dfs(grid, row,col-1);
        dfs(grid, row,col+1);

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("number of islands: " + numberOfIslands(grid));
    }

}

