import java.util.*;

public class 달리기순위 {
    public static void main(String[] args) {
        int[][] participants = {{5,15},{5,13},{3,14},{1,12},{4,11}};

        race(participants);
    }

    private static int[] race(int[][] participants) {
        int[] answer = new int[participants.length];//참가자 수만큼의 상품 획득 여부를 따져야하므로

        //도착시간을 기준으로 정렬을 해야 함.
        Map<Integer,Integer> map = new TreeMap<>();

        //<도착시간, 참가자번호>
        //트리맵에 넣으면 도착시간오름차순으로 정렬됨.
        for (int i = 0; i < participants.length; i++) {
            map.put(participants[i][1],i);//등수는 1부터 시작하므로
        }
        List<Integer> list = new ArrayList<>(map.keySet());

        //도착시간을 기준으로 정렬했을 때,list의 각 원소의 인덱스가 실제 등수-1 이다.

        for(int i = 0; i < list.size(); i++) {
            int num = map.get(list.get(i));//참가자 번호

            int end_score = i+1;//실제 도착 등수

            int goal_score = participants[num][0];//목표 순위

            if(end_score <= goal_score) {
                answer[num] = 1;
            }else{
                answer[num] = 0;
            }
            
        }
        for(int i=0;i<participants.length;i++) {
            System.out.print(answer[i]+" ");
        }
        return answer;

    }

}
