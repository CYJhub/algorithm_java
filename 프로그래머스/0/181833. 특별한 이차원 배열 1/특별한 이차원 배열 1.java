class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (i==j){ // 대각 행렬은 행광 열의 인덱스가 같음
                    answer[i-1][j-1] = 1;
                }
            }
        }
        return answer;
    }
}