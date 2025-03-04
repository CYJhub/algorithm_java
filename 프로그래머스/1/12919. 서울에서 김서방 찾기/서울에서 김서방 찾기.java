class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int idx = -1;
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        sb.append(String.valueOf(idx));
        sb.append("에 있다");
        return sb.toString();
    }
}