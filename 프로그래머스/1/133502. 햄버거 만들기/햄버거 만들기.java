import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int in:ingredient){
            st.push(in);
            
            if(st.size()>=4){
                int size = st.size();
                if(st.get(size-4)==1 &&
                    st.get(size-3)==2 &&
                   st.get(size-2)==3 &&
                   st.get(size-1)==1){
                    answer++;
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                }
                
            }
            
        }
        
        
        return answer;
    }
}
//빵=1
//야채=2
//고기=3