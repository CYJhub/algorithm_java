class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int y = x;
        while(x > 0){
            sum += (x%10);//각자리수의 합
            x = x/10;
        }
        System.out.println(sum);
        if(y%sum != 0){
            answer = false;
        }
        return answer;
    }
}