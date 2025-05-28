class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for(int sect:section){
            if(start + m > sect){ // 다시 칠할 필요 없음
                continue;
            }
            else{
                answer++;
                start = sect;
            }
            
        }
        return answer;
    }
}