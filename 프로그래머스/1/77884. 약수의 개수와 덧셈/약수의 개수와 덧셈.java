class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        boolean flag = true;
        for(int i=left;i<=right;i++){
            for(int j=1;j*j<=i;j++){
                if(j*j == i){
                    flag = false;
                }
            
            }
            if(flag){
                answer += i;
            }
            else{
                answer -= i;
            }
            flag = true;
        }
        return answer;
    }
}
// 약수의 개수가 홀수인 경우 제곱수 3*3=9
// 약수의 개수가 짝수인 경우 그 이외의 수
// 17의 경우 1부터 4까지만 순회할 수 있음
