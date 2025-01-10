import java.util.ArrayList;
import java.util.List;

class 배열만들기2 {
    public int[] solution(int l, int r) {
        
        List<Integer> result = new ArrayList<>();
        
        for( int i=l;i<=r;i++){
            if (isValid(i)){
                result.add(i);
            }
        }
        
        if (result.isEmpty()){
            result.add(-1);
        }
        
        
        return result.stream().mapToInt( i->i).toArray();
        
        
    }

    private boolean isValid(int num){
        String str = String.valueOf(num); 
        for ( char c : str.toCharArray()){
            if (c!='0' && c !='5'){
                return false;
            }
        }
        return true;
        
    }
}