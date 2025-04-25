import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();//기본 오름차순
        
        for(int s:scoville){
            pq.offer(s);
        }
        
        while(pq.size()>=2){
            if(pq.peek()>=K){
                return answer;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int newOne = first + 2*second;
            
            pq.offer(newOne);
            
            answer++;
        }
        if(pq.peek()>=K){
            return answer;
        }else{
            return -1;
        }
        
        
        //return answer;
    }
}