import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];//배열의 길이 = 문자열의 길이
        HashMap<Character, Integer> hm = new HashMap<>();// <알파벳, 인덱스>
        int idx = 0;
        for(Character c:s.toCharArray()){// 각각의 문자를 돌며
            hm.put(c,idx++); // key: 소문자 알파벳, value: 인덱스
        }
        //자신보다 앞에 있으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디에 있는지 확인하자.
        answer[0] = -1;//첫번째 원소는 무조건 -1
        boolean near = false;
        for(int i=1;i<s.length();i++){
            near = false;
            for(int j=i-1;j>=0;j--){//i와 가까운 쪽부터 훑기
                if(s.charAt(j)==s.charAt(i)){//같다면
                    answer[i] = i-j;//가장 가까운 인덱스
                    near = true;
                    break;
                }
            }
            if(!near){
                answer[i] = -1;
            }
            
        }
        
        return answer;
    }
}
// s의 원소와 인덱스를 저장하고 있는 해시맵을 생성?
//{b=0,a=1,n=2,a=3,n=4,a=5}