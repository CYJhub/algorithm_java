import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        //우선 예약이 들어온 순서대로 다시 재배열
        int[][] booking = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            int start = toTime(book_time[i][0]);
            int end = toTime(book_time[i][1]) + 10;//청소 시간 추가
            
            booking[i][0] = start;
            booking[i][1] = end;
        }
        Arrays.sort(booking, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        
        for(int[] book:booking){
            if(pq.isEmpty()){
                pq.add(book);
            }
            else{
                int[] tmp = pq.peek();
                int st = tmp[0];
                int en = tmp[1];
                
                if(en<=book[0]){
                    pq.poll();//원래 있던 걸 빼고
                    
                }
                pq.add(book);
            }
        }
        
        return pq.size();
    }
    
    
    //"HH:MM" 을 정수형 시각으로 변환
    private static int toTime(String time){
        String[] tArr = time.split(":");//:를 기준으로 시와 분을 분리
        int hour = Integer.parseInt(tArr[0]);
        int minute = Integer.parseInt(tArr[1]);
        return (hour*60) + minute;
    }
}
