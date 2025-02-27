class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();//append
        int left = 10; // *를 10로 설정
        int right = 12; // #를 12로 설정
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = numbers[i];// 왼손 위치 업데이트
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                right = numbers[i];// 오른손 위치 업데이트
            }
            else{// 2, 5, 8, 0 눌러야하는 경우
                if(numbers[i]==0) numbers[i]=11; //0일때는 11로 간주하여 계산
                int leftDistance = Math.abs(left-numbers[i])/3 + Math.abs(left-numbers[i])%3;
                int rigthDistance = Math.abs(right-numbers[i])/3 + Math.abs(right-numbers[i])%3;
                if(leftDistance<rigthDistance){
                    sb.append("L");
                    left = numbers[i];// 왼손 위치 업데이트
                }
                else if(leftDistance > rigthDistance){
                    sb.append("R");
                    right = numbers[i];// 오른손 위치 업데이트
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = numbers[i];// 오른손 위치 업데이트
                    }
                    else{
                        sb.append("L");
                        left = numbers[i];// 왼손 위치 업데이트
                    }
                }
            }
        }
        return sb.toString();
    }

}
// 상하좌우 4가지방향으로 이동
// 가운데 2580은 두 엄지 중 더 가까운 것을 사용
// 거리 같다면, 왼손 잡이 Or 오른손 잡이 인지 판별
// 마지막에 .toString()
// 147은 무조건 왼손
// 369는 무조건 오른손
// 2580 과 지금 왼손위치와 오른손 위치를 뺀 값을 절댓값을 씌워서 비교해서 더 작은 손으로 누른다.
// 같은 경우 hand를 기반으로 결정.
// 왼손 위치와 오른손 위치를 저장할 변수 생성(최근 위치만 저장하면 되므로)