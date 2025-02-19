class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] factors = new int[number];//각 기사 단원의 약수의 개수를 저장할 배열 생성
        for(int i=1;i<=number;i++){
            int cnt = 0;
            for(int j=1;j*j<=i;j++){
                if ((j*j)==i) cnt ++;
                else if ((i%j)==0) cnt += 2;
            }
            factors[i-1] = cnt;
        }
        for(int i=0;i<number;i++){
            if(factors[i]>limit){
                answer += power;
            }
            else{
                answer += factors[i];
            }
        }
        return answer;
    }
}
// 자신의 기사 번호의 "약수의 개수"에 해당하는 공격력을 가진 무기 구매
// 제한수치 < 공격력을 가진 무기 구매해야하는 기사는 -> 협약 기관에서 정한 공격력을 가진 무기를 구매해야함.
// 이중 반복문 = 시간 초과 발생
// 
