import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Point> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();//이미 계산되어 나온 숫자를 저장해서 두번쨰 이상부터는 무시==최소 횟수를 구해야 하므로
        queue.add(new Point(x,0));
        visited.add(x);
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            //만약 수가 y와 같다면 카운트 반환
            if(p.num==y){
                return p.count;
            }
            
            int[] values = {p.num+n,p.num*2,p.num*3};
            
            for(int value:values){
                if(!visited.contains(value) && value<=y){
                    queue.add(new Point(value,p.count+1));
                    visited.add(value);
                }
                
            }
            
        }
        
        return -1;
        
        
    }
    public static class Point{
        public int num;
        public int count;
        
        public Point(int num,int count){
            this.num = num;
            this.count = count;
        }
    }
}