import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int l_time = 0;//출발지~레버
        int e_time = 0;//레버~끝점
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        char[][] map = new char[maps.length][maps[0].length()];
        int[][] distance = new int[maps.length][maps[0].length()];//각 점에서의 거리 측정
        int curx = -1;
        int cury = -1;
        
        int lx = -1;
        int ly = -1;
        
        int endx = -1;
        int endy = -1;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                map[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S'){
                    curx = i;
                    cury = j;
                }else if(maps[i].charAt(j) == 'L'){
                    lx = i;
                    ly = j;
                }
                else if(maps[i].charAt(j) == 'E'){
                    endx = i;
                    endy = j;
                }
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(curx,cury));//시작점 넣어주기
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            //레버를 만나면 브레이크
            if(p.x == lx && p.y == ly){
                l_time = distance[p.x][p.y];
                break;
            }
            
            for(int[] dir:directions){
                int nx = p.x+dir[0];
                int ny = p.y+dir[1];
                
                if(isRange(nx,ny,maps.length, maps[0].length()) && maps[nx].charAt(ny)!='X' && distance[nx][ny] == 0){
                    distance[nx][ny] = distance[p.x][p.y] +1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
        //애초에 도달할 수 없다면 -1반환
        if(l_time == 0){
            return -1;
        }
        //다시 0으로 초기화
        for(int[] d:distance){
            Arrays.fill(d,0);
        }
        queue.clear();
        queue.add(new Point(lx,ly));//시작점 넣어주기
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            if(p.x == endx && p.y == endy){
                e_time = distance[p.x][p.y];
                break;
            }
            
            for(int[] dir:directions){
                int nx = p.x+dir[0];
                int ny = p.y+dir[1];
                
                if(isRange(nx,ny,maps.length, maps[0].length()) && maps[nx].charAt(ny)!='X' && distance[nx][ny] == 0){
                    distance[nx][ny] = distance[p.x][p.y] +1;
                    queue.add(new Point(nx,ny));
                }
            }
            
        }
        if(e_time == 0){
            return -1;
        }
        
        
        return l_time + e_time;
    }
    public static boolean isRange(int x,int y,int n,int m){
        return x>=0 && x<n && y>=0 && y<m;
    }
    public static class Point{
        public int x;
        public int y;
        
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
//따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 
//최소 시간은 bfs
//여러번 지나갈 수 있음.
