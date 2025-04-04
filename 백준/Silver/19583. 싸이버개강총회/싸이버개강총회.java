

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
import java.time.*;

public class Main {
    /*
    들어온 사람은 입장 시간 이전에 들어온 사람을 세고
    퇴장한 사람은 끝난시간~스트리밍이 끝남 시점 사이에 나간것이 확인된 사람.

    크기 고정이 없는 리스트에 입장한 사람을 추가함.
    끝난시간~스트리밍이 끝난 시점에 나간 사람이 리스트에 있으면 개수 세기
     */
    static String start;
    static String end;
    static String stream;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = st.nextToken();//시작 시간
        end = st.nextToken();//끝낸 시간
        stream = st.nextToken();//스트리밍 끝낸 시간

        int cnt =0;
        Set<String> entered = new HashSet<>(); // 입장한 사람
        Set<String> counted = new HashSet<>(); // 이미 센 사람 (중복 방지)

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            String time = st.nextToken();
            String name = st.nextToken();
            if(start.compareTo(time)>=0){
                entered.add(name);
            }else if(end.compareTo(time)<=0 && stream.compareTo(time)>=0){
                if (entered.contains(name) && !counted.contains(name)) {
                    counted.add(name);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

}
