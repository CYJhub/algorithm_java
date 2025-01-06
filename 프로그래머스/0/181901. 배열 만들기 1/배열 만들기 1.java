import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if ((i%k)==0) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}