import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Point> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;//row
        m = maps[0].length;//col
        
        map = new int[n][m];
        distance = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i][j];
                distance[i][j] = -1;//원점으로부터의 거리를 -1로 초기화
            }
        }
        //(1,1)지점부터 시작
        queue.offer(new Point(0,0));
        distance[0][0]=1;
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            //상하좌우 중에 1인걸 골라서 큐에 집어넣음.
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                //범위 안에 있고, 아직 한번도 방문하지 않았으며,길이 맞으면
                if(0<=nx&&nx<n&&0<=ny&&ny<m&&distance[nx][ny]==-1&&map[nx][ny]==1){
                    queue.offer(new Point(nx,ny));
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                }
            }
        }
        
        if(distance[n-1][m-1]==-1){
            answer = -1;
        }
        else{
            answer=distance[n-1][m-1];
        }
        
        return answer;
    }

    public static class Point{
        public int x;
        public int y;
        
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
//고정된 5*5 맵에 (1,1)에 상대팀은 (5,5)에 위치
//상하좌우로 움직일 수 있음.
//상대팀 진영에 도착할 수 없을 때는 -1
//0은 벽, 1은 길