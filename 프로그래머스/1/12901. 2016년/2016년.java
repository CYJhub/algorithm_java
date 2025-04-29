import java.util.*;

class Solution {
    static int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
    public String solution(int a, int b) {
        String answer = "";
        
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"MON");
        map.put(1,"TUE");
        map.put(2,"WED");
        map.put(3,"THU");
        map.put(4,"FRI");
        map.put(5,"SAT");
        map.put(6,"SUN");
        
        int day = getDate(a,b);
        
        
        return map.get((day%7+3)%7);
    }
    private static int getDate(int a, int b){
        int date = 0;
        for(int i=0;i<a-1;i++){
            date += month[i];
        }
        
        return date+b;
    }
}
//{31,29,31,30,31,30,31,31,30,31,30,31}윤년

//2016년 1월 1일은 금요일