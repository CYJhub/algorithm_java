class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        //둘다 초깃값은 0으로 되어 있음
        int[] servernum = new int[24];//24시간 동안 측정
        int[] count = new int[24];//24시간 동안 측정
        
        for(int i=0;i<24;i++){
            servernum[i] = 0;
            count[i] = 0;
        }
        
        for(int i=0;i<24;i++){
            if(players[i]>=m){
                if(players[i]<((servernum[i]+1)*m)){
                    continue;//이미 증설된 서버로 가능하다면 패스
                }
                // 추가로 필요한 인원 수
                int p = players[i] - servernum[i] * m;
                int n=1;
                while(true){
                    if(p<(n+1)*m){
                        break;
                    }
                    n++;
                }
                for(int j=i;j<i+k;j++){
                    if(j==24){
                        break;
                    }
                    servernum[j]+=n;//k시간 동안 운영
                }
                count[i] = n;
                
            }
        }
        int sum=0;
        for(int i=0;i<24;i++){
            sum+=count[i];
        }
        return sum;
    }
    
}