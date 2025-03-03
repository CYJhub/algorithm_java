import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        
        int player = stages.length; //플레이어의 수
        
        HashMap<Integer, Integer> map = new HashMap<>();//<스테이지 번호, 나온 수>
        
        for(int stage:stages){
            map.put(stage, map.getOrDefault(stage,0)+1);
        }
        System.out.println(map);
        
        HashMap<Integer, Double> failure = new HashMap<>();//<스테이지 번호, 실패율>
        
        for(int i=0;i<N;i++){//실패율 구해서 넣기
            Double fail = 0.0;
            if(player != 0 && i+2 != N+1){
                fail = (double)map.getOrDefault(i+1,0)/player;
                player -= map.getOrDefault(i+1,0);//플레이어 수 업데이트
                failure.put(i+1,fail);
                System.out.println(fail);
            }else if(player != 0 && i+2 == N+1){
                fail = (double)map.getOrDefault(i+1,0)/player;// 어차피 마지막이니까 업데잍트해줄 필요 없음.
                failure.put(i+1,fail);
                System.out.println(fail);
            }else if(player == 0){ // 스테이지에 도달한 유저가 없는 경우
                fail = 0.0;
                failure.put(i+1,fail);
            }
        }//실패율까지는 잘 구함!!
        System.out.println(failure);
        
        List<Integer> list = new ArrayList<>(failure.keySet());
        list.sort((x, y) -> failure.get(y).compareTo(failure.get(x)));//실패율을 기준으로 내림차순 정렬

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    

    }
}
// 실패율 = 스테이지에 도달하였으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 스테이지에는 1부터 N+1 
// N+1는 마지막까지 클리어한 플레이어
// 마지막 스테이지에서 확률을 구할때는 n+1로 계산해야 함.
// 실패율이 제일 높으면 우선순위 1, 실패율이 젤 낮으면 우선순위 5
// 실패율이 같은 경우, 