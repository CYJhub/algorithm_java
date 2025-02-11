import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        HashSet<Character> skipSet = new HashSet<>();

        // skip 문자들을 Set에 저장 (O(1) 조회)
        for (Character c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int moveCount = 0; // 실제로 이동한 횟수

            while (moveCount < index) { // 정확히 index만큼 이동할 때까지 반복
                currentChar++; // 다음 알파벳으로 이동

                if (currentChar > 'z') {
                    currentChar = 'a'; // z를 넘어가면 다시 a로
                }

                if (!skipSet.contains(currentChar)) {
                    moveCount++; // skip되지 않은 문자만 count 증가
                }
            }

            answer.append(currentChar);
        }

        return answer.toString();
    }
}
