class Solution {
    public int solution(int n, int[][] computers) {
        if(computers == null || computers.length == 0 || computers[0].length ==0){
            return 0;
        }
        boolean[] visited = new boolean[n];
        int answer = 0; // 네트워크의 개수
        for(int i=0;i<n;i++){
            if (!visited[i]){ // 방문하지 않았다면
                dfs(computers,visited,i);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int[][] computers, boolean[] visited,int com){
        visited[com] = true; // 방문 체크
        for(int i=0;i<computers.length;i++){
            if(computers[com][i] == 1 && !visited[i]){
                dfs(computers,visited,i);
            }
        }
    }
}
