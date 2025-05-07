class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (n+w-1)/w;//올림 수=행
        int col = w;//열
        
        int[][] boxes = new int[row][col];
        

        int k = 1;
        
        for(int i=row-1;i>=0;i--){//밑에서 부터 쌍아햐 하므로
            for(int j=0;j<col;j++){//좌우마다 방향이 다름
                if(row%2==0){
                    if(i%2!=0){
                        boxes[i][j] = k++;
                    }else{
                        boxes[i][col-j-1] = k++;
                    }
                }else{
                    if(i%2==0){
                        boxes[i][j] = k++;
                    }else{
                        boxes[i][col-j-1] = k++;
                    }
                }
                if(n<k){
                    break;
                }
            }
            if(n<k){
                break;
            }
        }

        int x=-1;
        int y=-1;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(boxes[i][j]==num){
                    x=i;
                    y=j;
                }
            }
        }
        for(int i=0;i<=x;i++){
            if(boxes[i][y]!=0){
                answer++;
            }
        }
        return answer;
    }
}