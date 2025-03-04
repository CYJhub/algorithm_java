class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==2) return 1;
        else{
            boolean flag = true;
        for(int i=3;i<=n;i+=2){//홀수 만큼 증가
            for(int j=2;(j*j)<=i;j++){//1과 자기 자신을 제외한 수로 나눠떨어지면 소수가 아니다.
                if ((i%j)==0){
                    flag = false;//소수 아님
                    break;
                }
            }
            if(flag){
                answer++;
            }
            flag = true;
        }
        return answer+1;
        }
    }
}
// 만약 n이 2이라면 답은 1로 반환
// 어떤 수가 자신의 절반에 해당하는 수까지