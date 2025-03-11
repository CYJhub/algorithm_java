class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(wallet[0],wallet[1])<Math.min(bill[0],bill[1]) ||
             Math.max(wallet[0],wallet[1])<Math.max(bill[0],bill[1])){
            if(bill[0]>=bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}
// 접을떈 항상 길이가 긴쪽을 접는다 = 정렬해서 인덱스0인걸 반으로 나눔.
// 대소비교 하면 
// 90돌려서 넣을 수 있다면 그냥 넣기
// 작은 값보다 작거나 큰값보다 작으면 넣을 수 있음