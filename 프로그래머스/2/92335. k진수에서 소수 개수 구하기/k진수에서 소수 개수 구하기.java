import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
//         Stack<Integer> st = new Stack<>();
//         while(n>0){
//             st.push(n%k);//나머지를 스택에 저장
//             n /= k;//k로 나눈 몫
//         }
//         int[] arr = new int[st.size()];
//         for(int i=0;i<arr.length;i++){
//             arr[i] = st.pop();
//         }
//         //	211020101011
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=0;i<arr.length;i++){
//             sb.append(arr[i]);
//         }
        String[] prime = Integer.toString(n,k).split("0");
        //String[] prime = sb.toString().split("0");
        for(int i=0;i<prime.length;i++){
            if(prime[i].length() == 0){
                continue;
            }
            if(isPrime(Long.parseLong(prime[i]))){
                answer++;
            }
        }
        
        return answer;
    }
    private static boolean isPrime(long num){
        if(num==1){
            return false;
        }
        boolean flag = true;
        for(long i=2;i*i<=num;i++){
            if(num%i == 0){
                flag = false;//나눠진다면 소수가 아니니까
                break;
            }
        }
        return flag;
    }
}
//먼저 N을 k진수로 바꾸려면 k로 계속 나눈 후에 나머지를 뒤에서부터 저장하면서 바꾼다.