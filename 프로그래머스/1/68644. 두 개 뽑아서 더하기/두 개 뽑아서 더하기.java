import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int num = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                num = numbers[i]+numbers[j];
                map.put(num,1);//map은 중복을 허용하지 않음.
            }
        }
        int[] answer = new int[map.size()];

        return map.keySet().stream().mapToInt(x -> x).sorted().toArray();
    }
}// 중복된 값을 제외
//해시맵을 사용 ketSet() 
// map.keySet() => Set<Integer>