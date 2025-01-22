class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int k;
        
        if( len % n == 0){
            k = len/n;
        }
        else{
            k = len/n +1;
        }
        String[] answer = new String[k];
        
        String temp="";
        
        for(int i=0;i<len;i+=n){
            // if(i+n >= len){
            //     temp = my_str.substring(i,len);
            // }
            // else{
            //     temp = my_str.substring(i,i+n);
            // }
            // answer[i/n] = temp;
            answer[i/n] = my_str.substring(i,Math.min(i+n,len));
        }
        return answer;

    }
}