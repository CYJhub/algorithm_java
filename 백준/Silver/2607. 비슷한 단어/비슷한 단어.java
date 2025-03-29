
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static String word;//첫번째 단어
    static Map<Character, Integer> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        word = br.readLine();

        //첫번째 단어의 단어와 개수 매칭
        for(char wordChar : word.toCharArray()){
            map.put(wordChar, map.getOrDefault(wordChar, 0) + 1);
        }
        int cnt=0;

        for(int i=0;i<N-1;i++){
            String s = br.readLine();
            if(isSimilar(s) || isSymmetric(s)){
                cnt++;
            }

        }
        System.out.println(cnt);

    }
    //같은 구성
    private static boolean isSymmetric(String s){
        Map<Character, Integer> sMap = new TreeMap<>();
        for(char wordChar : s.toCharArray()){
            sMap.put(wordChar, sMap.getOrDefault(wordChar, 0) + 1);
        }
        return sMap.equals(map);
    }
    //비슷한 단어
    //한 단어에서 한 문자를 더하거나, 빼거나,
    // 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우
    private static boolean isSimilar(String s) {
        Map<Character, Integer> sMap = new TreeMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> origin = new TreeMap<>(map); // 첫 단어 복사

        int diff = 0;

        for (char c : origin.keySet()) {
            int a = origin.getOrDefault(c, 0);
            int b = sMap.getOrDefault(c, 0);
            diff += Math.abs(a - b);
            sMap.remove(c); // 중복 비교 방지
        }

        for (int val : sMap.values()) {
            diff += val;
        }

        int lenDiff = Math.abs(word.length() - s.length());

        return diff == 1 || (diff == 2 && lenDiff == 0);
    }


}
