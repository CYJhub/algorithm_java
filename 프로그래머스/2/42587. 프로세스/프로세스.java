import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Process> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//내림차순
        for(int i=0;i<priorities.length;i++){
            queue.offer(new Process(priorities[i],i));
            //list.add(p);
            pq.offer(priorities[i]);
        }
        int idx = 0;
        while(!queue.isEmpty()){
            Process current = queue.peek();//일단 맨 앞에 있는거 뽑아
            // 만약 현재 값이 가장 큰 값이 아니라면
            if(current.priority<pq.peek()){
                queue.poll();//앞에서 빼서
                queue.offer(current);//맨 뒤에 넣음
            }else{
                list.add(queue.poll());
                pq.poll();
            }
        }
        //근데 이게 이제 몇번째 인덱스인지 알아야 함
        //3 2 2 1 
        
        for(int i=0;i<list.size();i++){
            //System.out.println(list.get(i).idx);
            result.add(list.get(i).idx);
        }
        return result.indexOf(location)+1;
    }
    public class Process{
        public int priority;
        public int idx;
        
        public Process(int priority,int idx){
            this.priority = priority;
            this.idx = idx;
        }
    }
}