import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(arr[0]); // 첫번째 원소는 무조건 들어감
        
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] == arr[i]) continue;
            queue.add(arr[i]);
        }
        
        while(!queue.isEmpty()){
            answer.add(queue.remove());
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
