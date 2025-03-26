class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k,dungeons,0,visited);//현재 피로도, 던전, 탐험한 던전 수, 방문 여부
        return answer;
    }
    private static void dfs(int k,int[][] dungeons, int cnt, boolean[] visited){
        answer = Math.max(answer,cnt);
        
        for(int i=0;i<dungeons.length;i++){
            int required = dungeons[i][0];
            int consumed = dungeons[i][1];
            
            if(!visited[i] && k>=required){
                visited[i] = true;
                dfs(k-consumed,dungeons, cnt+1, visited);
                visited[i]  = false;
            }
        }
    }
}