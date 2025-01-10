class 이차원배열대각선순회하기 {
    public int solution(int[][] board, int k) {
        int answer = 0;
        int col_len = board[0].length; 
        int row_len = board.length;
        
        
        for(int i=0;i<row_len;i++){
            for(int j=0;j<col_len;j++){
                if ((i+j)<=k){
                    answer += board[i][j];
                }
            }
        }
        return answer;
    }
}