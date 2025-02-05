class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String newstr = myString.toLowerCase();
        String newpat = pat.toLowerCase();
        if(newstr.contains(newpat)){
            answer = 1;
        }
        return answer;
    }
}