class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len = myString.length() - pat.length() + 1;
        String[] words = new String[len];
        for(int i=0 ; i<len ; i++){
            words[i] = myString.substring(i,i+pat.length());//마지막 원소 안 들어감.
            if(words[i].equals(pat)){
                answer++;
            }
        }
        return answer;
    }
}