class 특별한이차원배열2 {
    public int solution(int[][] arr) {
        // 대칭 행렬인지 검사
        int len = arr[0].length; // arr의 길이 
        int answer = 1;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (arr[i][j] != arr[j][i]){
                    answer = 0;
                }
            }
        }
        
        return answer;
    }
}