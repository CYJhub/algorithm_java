class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for(String bab:babbling){
            String temp = bab;
            boolean isValid = true;
            String prev = "";
            while(!temp.isEmpty()){
                boolean matched = false;
                for(String word:words){
                    if(temp.startsWith(word) && !prev.equals(word)){
                        temp = temp.substring(word.length());
                        prev = word;
                        matched = true;
                        break;
                    }
                }
                if(!matched){
                    isValid = false;
                    break;
                }
            }
            if(temp.length()==0){
                answer++;
            }
        }
        return answer;
    }
}
//그니까 문자열 하나가 모두 옹알이로만 이루어져있어야 함.
//"woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
//각자 발음과 네 가지 발음을 조합해서 만들 수 있는 발음
//연속해서 발음하는 것은 어려움.