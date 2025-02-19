import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);//오름차순 배열
        int start = 0;
        int end = score.length-m;
        while(end >= 0){ //m개씩 사과를 묶을 수 있을 때까지  
            answer += (m*score[end]);
            end -= m;
        }
        return answer;
    }
}
// 관건: 스코어 중 m개를 골랐을 때 최하 점수가 가장 높아야 함.
// 배열을 오름차순 정렬 한후, 끝에서 부터 m개씩 잘라
// 길이가 7
// 7-4=3
// 0,1,2,3,4,5,6