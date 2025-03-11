import java.util.*;

class Solution {
    static Set<Integer> result = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = numbers.split("");//각 숫자 분리
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i=1;i<=numbers.length();i++){
            permute("",numbers,visited,i);
        }
        
        for(int num:result){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    static public void permute(String current,String numbers,boolean[] visited,int len){
        if(current.length()==len){
            result.add(Integer.parseInt(current));
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                permute(current+numbers.charAt(i),numbers,visited,len);
                visited[i] = false;
            }
            
        }
    }
    //소수인지 판별하는 함수
    public boolean isPrime(int num){
        if(num<2){ return false;}
        for(int i=2;i*i<=num;i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
//Integer.parseInt(string);
//일단 가질 수 있는 모든 경우의 수를 조합해야 함