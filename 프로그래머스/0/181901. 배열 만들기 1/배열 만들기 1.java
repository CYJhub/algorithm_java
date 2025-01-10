import java.util.*;

class 배열만들기 {
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