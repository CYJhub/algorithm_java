class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};
        for(int k=0;k<4;k++){
            int h_check = h+dh[k];
            int w_check = w+dw[k];
            if(0<=h_check && h_check<row && 0<=w_check && w_check<col){
                if(board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
        }
        return count;
    }
}