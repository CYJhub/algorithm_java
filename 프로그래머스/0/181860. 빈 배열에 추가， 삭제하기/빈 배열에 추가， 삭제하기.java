import java.util.ArrayList;
import java.util.List;

class 빈배열에추가삭제하기 {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++){ // arr과 flag 배열의 길이가 같음
            if (flag[i]== true){
                for(int j=0;j<arr[i]*2;j++){
                    result.add(arr[i]); 
                }
            }
            else {
                for(int j=0;j<arr[i];j++){
                    result.remove(result.size()-1); 
                }
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}