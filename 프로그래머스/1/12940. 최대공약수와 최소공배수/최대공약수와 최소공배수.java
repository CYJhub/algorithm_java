class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n,m);// 둘 중 큰수를 저장한다.
        int min = Math.min(n,m);// 둘 중 작은수를 저장한다.
        
        int a=0;
        for(int i=1;i<=min;i++){
            if ((max%i)==0 && (min%i)==0){
                a = i;
            }
        }

        int b = m*n;
        if((max%min)==0){
            b=max;
        }
        else{
            b = b/a;
        }
        answer[0] = a;
        answer[1] = b;

        return answer;
    }
}