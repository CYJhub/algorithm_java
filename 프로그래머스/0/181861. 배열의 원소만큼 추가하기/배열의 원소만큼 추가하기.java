class Solution {
    public int[] solution(int[] arr) {
        int [] answer;
        int sum =0;
        
        for(int i:arr){
            sum +=i;
        }
        // 길이가 sum인 배열을 선언한다.
        answer = new int[sum];
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}