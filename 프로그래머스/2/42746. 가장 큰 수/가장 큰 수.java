import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        //o2+o1한 것이 o1+o2보다 크면 앞에 정렬
        Arrays.sort(arr, (o1,o2)->(o2+o1).compareTo(o1+o2));
        
        StringBuilder sb = new StringBuilder();
        for(String num:arr){
            sb.append(num);
        }
        answer = sb.toString();
        if(answer.startsWith("0")){
            answer = "0";
        }
        
        return answer;
    }
}
//각 숫자를 큰자리수부터 비교해서