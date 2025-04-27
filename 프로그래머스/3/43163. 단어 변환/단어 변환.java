import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        boolean isInclude = false;
        for(String word:words){
            if(word.equals(target)){
                isInclude = true;
            }
        }
        if(!isInclude){
            return 0;
        }
        Queue<Word> queue = new LinkedList<>();
         boolean[] visited = new boolean[words.length];
        queue.add(new Word(begin,0));
        
        while(!queue.isEmpty()){
            Word w = queue.poll();
            if(w.word.equals(target)){
                return w.cnt;
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i] && isSimilar(w.word,words[i])){
                    visited[i] = true;
                    queue.offer(new Word(words[i],w.cnt+1));
                }
            }
            
        }
        return answer;
    }
    
    //주어진 단어와 알파벳 하나만 똑같고 나머지는 다른 단어 확인
    private static boolean isSimilar(String a, String b){
        int cnt = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1 ? true:false;
    }
    public class Word{
        String word;
        int cnt;
        
        Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
}


