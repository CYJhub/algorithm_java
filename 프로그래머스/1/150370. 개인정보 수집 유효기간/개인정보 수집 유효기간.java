import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> term = new HashMap<>();//<약관 번호, 유효 기간>
        for(String t:terms){
            String[] arr = t.split(" ");
            term.put(arr[0],Integer.parseInt(arr[1]));
        }
        
        int day = toDate(today);
        
        for(int i=0;i<privacies.length;i++){
            String[] pArr = privacies[i].split(" ");
            int m = term.get(pArr[1]);//약관 종류에 해당하는 개월 수를 가져옴
            int date = toDate(pArr[0]);
            if(date + (m*28) <= day){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    private static int toDate(String today){
        String[] arr = today.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return (year*12*28)+(month*28)+day;
    }
}
//유효기간<오늘날짜 이면 파기 (같은 것 까지는 유효한걸로 판단)
