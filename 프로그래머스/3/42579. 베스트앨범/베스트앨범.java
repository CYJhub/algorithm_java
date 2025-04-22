import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int len = genres.length;
        Map<String,Integer> genreMap = new HashMap<>();//<장르:총 재생 횟수>
        //Map<Integer,Integer> playMap = new HashMap<>();//<노래 재생 횟수:고유번호>
        Map<String,List<int[]>> genre_play = new HashMap<>();//<장르:{속한 노래 재생 횟수,고유번호}>
        //pop: [600, 2500]
        //classic: [500, 150, 800]
        for(int i=0;i<len;i++){
            genreMap.put(genres[i],genreMap.getOrDefault(genres[i],0)+plays[i]);
            //playMap.put(plays[i],i);
            genre_play.putIfAbsent(genres[i],new ArrayList<>());
            genre_play.get(genres[i]).add(new int[]{plays[i],i});
        }
        
        for(String g:genre_play.keySet()){
            List<int[]> list = new ArrayList<>(genre_play.get(g));
            //Collections.sort(list,Collections.reverseOrder());//내림차순 정렬
            //장르내에서 재생 횟수가 같으면 고유 번호가 낮은 순서대로
            list.sort((a,b)->{
                if(a[0]!=b[0]){
                    return b[0]-a[0];//내림차순
                }else{
                    return a[1]-b[1];//고유번호가 낮은 순서대로
                }
            });
            genre_play.put(g,list);
             
        }
        List<String> gList = new ArrayList<>(genreMap.keySet());
        gList.sort((a,b)->genreMap.get(b)-genreMap.get(a));
        
        for(int i=0;i<gList.size();i++){
            List<int[]> songs = genre_play.get(gList.get(i));
            if(songs.size()==1){//곡이 하나라면 하나만 선택
                answer.add(songs.get(0)[1]);
            }else{//두개 이상일때,
                answer.add(songs.get(0)[1]);
                answer.add(songs.get(1)[1]);
            }
        }
        
        return answer.stream().mapToInt(x->x).toArray();

    
    }
}
//장르 별로 "두개씩" 모아 앨범을 만듬
//속한 노래가 많이 재생된 장르를 먼저 수록
//장르내에서 많이 재생된 노래를 먼저 수록
//장르내에서 재생 횟수가 같으면 고유 번호가 낮은 순서대로
//단 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.