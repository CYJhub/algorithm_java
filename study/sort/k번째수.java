import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int rows = commands.length;
        
        int[] answer = new int[rows];
        
        for(int i=0;i<rows;i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2]-1;
            
            int[] subarray= Arrays.copyOfRange(array, start, end);
            Arrays.sort(subarray);
            
            answer[i] = subarray[k];
        }
        
        return answer;
    }
}
