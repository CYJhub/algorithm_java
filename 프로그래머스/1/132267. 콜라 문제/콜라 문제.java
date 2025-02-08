class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int quotient = 0;//몫
        int remainder = 0;//나머지
        int last = 0;
        while(n/a > 0){//몫이 1이상일 때까지
            quotient = (n/a)*b;
            remainder = n%a;
            answer += quotient;
            n = quotient + remainder;
        }
        return answer;
    }
}