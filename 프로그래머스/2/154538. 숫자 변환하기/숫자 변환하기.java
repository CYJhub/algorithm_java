import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{x,0});
        visited.add(x);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int count = cur[1];
            
            if(num == y){
                answer = count;
                return answer;
            }
            int[] values = {num+n,num*2,num*3};
            
            for(int value:values){
                if(value<=y && !visited.contains(value)){
                    visited.add(value);
                    queue.add(new int[]{value,count+1});
                }
            }
        }
        return -1;
    }
}