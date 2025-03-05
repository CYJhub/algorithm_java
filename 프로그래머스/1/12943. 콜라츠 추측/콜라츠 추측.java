class Solution {
    public int solution(long num) {
        int answer = 0;
        
        if(num==1) return 0;
        
        while(num > 1){ // 1이 나올때까지
            if(num%2 == 0){
                num = divide(num);
                answer++;
            }
            else{
                num = multiple(num);
                answer++;
            }
            
            if(answer > 500){
                answer = -1;
                break;
            }
        }
    
        return answer;
    }
    
    // 짝수일 때 2로 나눔
    public long divide(long even){
        return even/2;
    }
    
    // 홀수일 때 3을 곱하고 1을 더함
    public long multiple(long odd){
        return 3*odd + 1;
    }
}
