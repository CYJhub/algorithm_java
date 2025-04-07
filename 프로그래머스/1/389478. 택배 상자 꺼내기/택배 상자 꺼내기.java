class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (n+w-1)/w;
        int[][] boxes = new int[row][w];//박스 2차원 배열 생성
        
        int q = row-1;
        int r = n%w;
        int boxnum=1;
        for(int i=q;i>=0;i--){
            if((q-i) % 2 == 0){
                for(int j=0;j<w&&boxnum<=n;j++){
                    boxes[i][j] = boxnum++;
                }
            }else{
                for(int j=w-1;j>=0&&boxnum<=n;j--){
                    boxes[i][j] = boxnum++;
                }
            }
        }
        //num이 [i][j]에 있는지 알아야 한다.
        //row - (num-1/w) -1 -> 0부터 시작하므로 1 빼줌
        //col
        int hid = -1;
        int wid = -1;
        for(int i=0;i<row;i++){
            for(int j=0;j<w;j++){
                if(boxes[i][j]==num){
                    hid = i;
                    wid = j;
                    break;
                }
            }
        }
        // int hid = row - ((num-1)/w) -1;
        // int wid = w-(num/w)-1;
        for(int i=0;i<=hid;i++){
            if(boxes[i][wid]!=0){
                answer++;
            }
        }

        return answer;
    }
}