import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);//오름차순 정렬
        int left = 0;
        int right = people.length-1;
        
        while(left<=right){
            int min = people[left];
            int max = people[right];
            
            if(min+max<=limit){
                left++;
            }
            right--;//리밋보다 커져도 우선 큰 사람은 들어감
            answer++;
            
        }
        
        return answer;
    }
}
// 구명 보트는 한번에 무조건 2명씩, 최대 무게 제한도 있음
// 이런 거는 이중 for문 쓰면 시간 초과날 가능성 있음
// 일단 오름차순 정렬