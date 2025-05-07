class Solution {
    public int solution(String[][] board, int h, int w) {
        int R = board.length;
        int C = board[0].length;
        
        int count = 0;
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int[] dir:directions){
            int h_check = h+dir[0];
            int w_check = w+dir[1];
            
            if(h_check>=0 && h_check<R && w_check>=0 && w_check<R){
                if(board[h_check][w_check].equals(board[h][w])){
                    count++;
                }
            }
        }
        
        
        return count;
    }
}