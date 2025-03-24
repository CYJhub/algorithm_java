class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];//가로>=세로 크기 반환
        
        int total = brown+yellow;
        int w;//가로
        int h;//세로
        for(int i=1;i*i<=total;i++){
            if(total%i==0){
                w = Math.max(i,total/i);//더 큰수가 가로
                h = Math.min(i,total/i);
                
                if((w-2)*(h-2)==yellow){
                    answer[0]=w;
                    answer[1]=h;
                    break;
                }
            }
        }
        
        return answer;
    }
}