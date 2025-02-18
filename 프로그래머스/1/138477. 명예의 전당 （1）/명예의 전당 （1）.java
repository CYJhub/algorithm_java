import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위 큐 사용
        int temp = 0;
        for(int i=0;i<score.length;i++){
            pq.add(score[i]);
            if(pq.size()>k){
                pq.poll();//맨 앞에서 원소를 빼내는 것 제거
            }
            answer[i] = pq.peek();// 맨 앞에 있는 원소를 반환하지만 제거x
        }
        return answer;
    }
}