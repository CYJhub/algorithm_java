import java.io.*;
import java.util.*;

public class Main {
    /*
    각 인데스에서 가장 많이 등장한 dna 뉴클레오티드를 찾아서 넣기
    여러개일 경우, 알파벳 순으로 정렬
     */

    static int N;
    static int M;
    static String[] dna;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        dna = new String[N];

        for(int i=0;i<N;i++) {
            dna[i] = br.readLine();
        }
        
        for(int i=0;i<M;i++) {
            Map<Character,Integer> map  = new HashMap<>();
            //각 인덱스에서 가장 많이 나온 알파벳을 집어넣음
            for(int j=0;j<N;j++) {
                if('T'==dna[j].charAt(i)){
                    map.put('T',map.getOrDefault('T',0)+1);
                }
                else if('A'==dna[j].charAt(i)){
                    map.put('A',map.getOrDefault('A',0)+1);
                }
                else if('C'==dna[j].charAt(i)){
                    map.put('C',map.getOrDefault('C',0)+1);
                }
                else if('G'==dna[j].charAt(i)){
                    map.put('G',map.getOrDefault('G',0)+1);
                }
            }
            List<Character> list = new ArrayList<>(map.keySet());
            list.sort((a, b) -> {
                if (!map.get(a).equals(map.get(b))) {
                    return map.get(b) - map.get(a); // 빈도수 내림차순
                } else {
                    return a - b; // 알파벳 오름차순
                }
            });


            //가장 많이 나타난 알파벳을 집어 넣음
            sb.append(list.get(0));


            map.clear();//초기화
        }
        System.out.println(sb.toString());
        System.out.println(hammingDistance(sb.toString(), dna));

    }
    private static int hammingDistance(String s, String[] arr) {
        int cnt=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<M;j++){
                if(s.charAt(j)!=arr[i].charAt(j)){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}
