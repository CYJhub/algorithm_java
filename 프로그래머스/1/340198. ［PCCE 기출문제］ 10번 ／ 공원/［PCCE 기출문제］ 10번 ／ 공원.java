import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int max = -1;//들어갈 수 있는 가장 큰 한변의 길이가 들어갈 변수
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                if(park[i][j].equals("-1")){
                    int cnt=0;
                    while(true){
                        boolean isSquare = true;
                        if(i+cnt>=park.length ||  j+cnt>=park[0].length){
                            break;
                        }
                        for(int x=i;x<=i+cnt;x++){
                            for(int y=j;y<=j+cnt;y++){
                                if(!park[x][y].equals("-1")){
                                    isSquare = false;//하나라도 -1이 아니면
                                    break;
                                }
                            }
                            if (!isSquare) break;
                        }
                        if(isSquare){
                            max = Math.max(max,cnt+1);
                            cnt++;
                        }
                        else{
                            break;
                        }

                    }
                }
            }
        }
        Arrays.sort(mats);
        if(mats[0]>max){
            return -1;
        }
        for(int mat:mats){
            if(mat<=max){
                answer = mat;
            }
        }
        return answer;
    }

}
//i,j => (i+1,j ) (i+1,j+1) (i,j+1)가 일단 범위안에 있어야 하고
//저 범위안이 모두 -1일때까지 증가 시킴