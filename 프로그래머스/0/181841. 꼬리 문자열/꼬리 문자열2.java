class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();
        int len = str_list.length;
        
        for(int i=0;i<len;i++){
            if (!str_list[i].contains(ex)){
                answer.append(str_list[i]);
            }
        }
        return answer.toString();
    }
}
