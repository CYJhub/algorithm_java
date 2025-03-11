import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxw = 0;//가로
        int maxh = 0;//세로
        for(int[] card:sizes){
            int w = Math.max(card[0],card[1]);//둘 중 큰거
            int h = Math.min(card[0],card[1]);//둘 중 작은거
            maxw = Math.max(maxw,w);
            maxh = Math.max(maxh,h);
        }
        return maxw*maxh;
    }
}