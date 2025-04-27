import java.util.*;

class Solution {
    static List<String> route = new ArrayList<>();
    static boolean[] visited;
    List<String> answer = null;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets,(a,b)->a[1].compareTo(b[1]));
        
        route.add("ICN");
        dfs("ICN", tickets);

        
        return answer.toArray(new String[0]);
    }
    private void dfs(String current, String[][] tickets){
        if(route.size()==tickets.length+1){
            if (answer == null) {
                answer = new ArrayList<>(route);  // 사전순 첫 번째 경로 저장
            }
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1],tickets);
                route.remove(route.size()-1);
                visited[i] = false;
            }
        }
    }
    
}