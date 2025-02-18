import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minheap
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());//maxheap
        
        for(String op : operations){
            String[] ops = op.split(" ");//스페이스바를 기준으로 분리한다. 두개로 나눠질 것임
            if(ops[0].equals("I")){
                pq.add(Integer.parseInt(ops[1]));//String -> int 형으로 바꿔 우선순위 큐에 넣음 
                maxpq.add(Integer.parseInt(ops[1]));
            }
            else{//"D"라면,
                if(!pq.isEmpty()){
                    if(ops[1].equals("-1")){//최솟값 삭제
                        int min = pq.poll();// 맨 앞에 있는 원소를 반환 후 제거
                        maxpq.remove(min);
                    }
                    else{//최댓값 삭제
                        int max = maxpq.poll();
                        pq.remove(max);
                    }
                }
            }
        }
        int[] answer = new int[2];
        if(pq.size()>=1){
            answer[0] = maxpq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}
// (-642) -45  45 97 333 653
// (653) (97) 333 45 -45 -642 
// (-5643) (16) 123
// (16) (-5643) 123