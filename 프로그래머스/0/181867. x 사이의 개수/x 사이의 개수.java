import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> result = new ArrayList<>();
        
        int[] answer = {};
        // 사이의 문자를 세기 위한 변수
        int cnt = 0 ;
        // 문자열을 각 문자 하나로 분할
        for(char c: myString.toCharArray()){
            if(c == 'x'){
                result.add(cnt);
                cnt = 0;// 초기화
            }
            else{
                cnt += 1; // 사이의 개수 1 증가
            }
        }
        result.add(cnt);
        return result.stream().mapToInt(x->x).toArray();
    }
}