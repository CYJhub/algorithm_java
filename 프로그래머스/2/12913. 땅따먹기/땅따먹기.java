class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        for(int i=1;i<land.length;i++){
            land[i][0] += max(land[i-1][1],land[i-1][2],land[i-1][3]);
            land[i][1] += max(land[i-1][0],land[i-1][2],land[i-1][3]);
            land[i][2] += max(land[i-1][0],land[i-1][1],land[i-1][3]);
            land[i][3] += max(land[i-1][1],land[i-1][2],land[i-1][0]);
        }
        answer = Math.max(Math.max(Math.max(land[len-1][0], land[len-1][1]),land[len-1][2]),land[len-1][3]);


        return answer;
    }
    public int max(int a,int b,int c){
        return Math.max(Math.max(a,b),c);
    }
}