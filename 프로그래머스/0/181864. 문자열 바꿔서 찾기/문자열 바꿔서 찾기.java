class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        
        for(char c:myString.toCharArray()){
            if (c=='A'){
                c='B';
                str.append(c);
            }
            else{
                c='A';
                str.append(c);
            }
        }
        String temp = str.toString();
        if(temp.contains(pat)){
            answer = 1;
        }
        return answer;
    }
}