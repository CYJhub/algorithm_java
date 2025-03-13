import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<int[]> file = new ArrayList<>();
        int col = wallpaper[0].length();
        
        Set<Integer> rowSet = new TreeSet<>(); // ***** 정렬가능한 셋
        
        Set<Integer> colSet = new TreeSet<>();
        
        int row = wallpaper.length;
        int lux = 0;//열 중에 가장 작은 것
        int luy = 0;//행 중에 가장 작은 것
        // lux,luy는 i,j그대로
        // rdx,rdy는 +1 해줘야 함.
        int rdx = 0;//열 중에 가장 큰 것
        int rdy = 0;//행 중에 가장 큰 것
        
        for(int i=0;i<row;i++){//i는 y rowSet
            for(int j=0;j<col;j++){//j는 x colSet
                if(wallpaper[i].charAt(j)=='#'){//지금 파일의 위치는 (i+1,j+1)
                    rowSet.add(i);
                    colSet.add(j);
                }
            }

        }

        List<Integer> sortedrow = new ArrayList<>(rowSet);
        
        List<Integer> sortedcol = new ArrayList<>(colSet);
        
        int rowL = sortedrow.size();
        int colL = sortedcol.size();
        
        answer[0] = sortedrow.get(0);
        answer[1] = sortedcol.get(0);
        answer[2] = sortedrow.get(rowL-1)+1;
        answer[3] = sortedcol.get(colL-1)+1;
        return answer;
    }
}
//가장 왼쪽에 있는 점부터 시작 = lux 4
//가장 오른쪽에 있는 점에서 끝 = rdx 8

//가장 위에 있는 점에서 시작 = luy = 2
//가장 밑에 있는 점에서 끝 = rdy5

// 세로축이 행 = y값
// 가로축이 열 = x값