class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for(int sect:section){
            if(start + m > sect){
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
//일단은 벽의 길이/롤러의 길이(수 반올림)를 하면 최대의 페인트칠 개수가 나온다. (n + m - 1)/m
// 섹션의 첫번째 원소부터 돌면서 2+4<=6 이면 한번 더 롤러칠을 해야함
// 1+4>3 이면 롤러칠 안해도됨
// 1+1<=2 롤러칠 해야함