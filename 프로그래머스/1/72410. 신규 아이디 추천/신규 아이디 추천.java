import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        char[] chr = new_id.toCharArray();
        
        StringBuilder sb  = new StringBuilder();
        //1단계
        for(int i=0;i<chr.length;i++){
            if(chr[i]>='A' && chr[i]<='Z'){
                chr[i] += 32;
 
            }
            //System.out.print(c);
        }
        //2단계
        for(char c:chr){
            if(isAlphabet(c) || isNumber(c) || c=='-' || c=='_' || c=='.'){
                sb.append(c);
            }
        }
        String step2 = sb.toString();
        System.out.println(step2);
        //3단계
        StringBuilder s2  = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<step2.length();i++){
            char c = step2.charAt(i);
            
            if(c=='.'){
                s2.append(step2.charAt(i));
                while(i+1<step2.length() && step2.charAt(i+1)=='.'){
                i++;
                }
            }else{
                s2.append(step2.charAt(i));
            }
        }
        System.out.println(s2.toString());
        String step3 = s2.toString();
        StringBuilder s3  = new StringBuilder();
        for(int i=0;i<step3.length();i++){
            if(i==0 && step3.charAt(i)=='.'){
                continue;
            }
            if(i==step3.length()-1 && step3.charAt(i)=='.'){
                continue;
            }
            
            s3.append(step3.charAt(i));

        }
        System.out.println(s3.toString());
        
        String step4 = s3.toString();
        if(step4.equals(".")){
            step4 = "";
        }
        
        if(step4.isEmpty()){
            step4 = "a";
        }
        
        if(step4.length()>=16){
            step4 = step4.substring(0,15);
        }
        
        
        if(step4.charAt(step4.length()-1)=='.'){
            step4 = step4.substring(0,step4.length()-1);
        }
        System.out.print(step4);
        
        if(step4.length()<3){
            String x = String.valueOf(step4.charAt(step4.length()-1));
            while(step4.length()<3){
                step4 += x;
            }
        }
        
        //4단계
        return step4;
    }
    private static boolean isAlphabet(char c){
        if(c>='a' && c<='z'){
            return true;
        }
        return false;
    }
    private static boolean isNumber(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }
}