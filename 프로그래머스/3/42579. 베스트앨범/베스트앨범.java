import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르별 총 재생횟수
        Map<String, Integer> music = new HashMap<>();//<장르,재생횟수합>
        for(int i=0;i<genres.length;i++){
            music.put(genres[i],music.getOrDefault(genres[i],0)+plays[i]);
        }
        //System.out.println(music);	{pop=3100, classic=1450}
        
        // 재생횟수 기준 내림차순 genre 에는 재생횟수로 내림차순
        List<String> genre = new ArrayList<>(music.keySet());
        genre.sort((x, y) -> music.get(y).compareTo(music.get(x)));
        //----------------------
        
        // 3. 장르별 (고유번호, 재생횟수) 리스트 저장
        Map<String, List<int[]>> gp = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            gp.putIfAbsent(genres[i], new ArrayList<>());
            gp.get(genres[i]).add(new int[]{i, plays[i]}); // {고유번호, 재생횟수}
        }
        
        
        // 장르 안에 있는 재생횟수를 내림차순****************
        for (List<int[]> songs : gp.values()) {
            songs.sort((a, b) -> {
                if (a[1] == b[1]) { // 재생 횟수가 같다면
                    return a[0] - b[0]; // 고유번호 기준 오름차순
                }
                return b[1] - a[1]; // 기본 내림차순 정렬 (재생 횟수 기준)
            });
        }
        
        for(String gen:genre){
            List<int[]> lst = gp.get(gen);
            answer.add(lst.get(0)[0]);
            if(lst.size()>1){
                answer.add(lst.get(1)[0]);
            }
        }
    
        
        // 단, 재생 횟수가 같으면 고유 번호 낮은 것 부터
        return answer.stream().mapToInt(x -> x).toArray();
    }
}
// 장르별로 가장 많이 재생된 노래를 두개씩 모아!
// 고유번호 낮은 거 먼저 수록
// 일단 장르별로 재생된 수를 모두 더해서 많이 재생된 횟수 기준 내림차순
// 순서대로 장르별 재생된 횟수 내림차순으로 2개골라 (그런데 재생 횟수 같으면 고유번호 낮은 것부터)