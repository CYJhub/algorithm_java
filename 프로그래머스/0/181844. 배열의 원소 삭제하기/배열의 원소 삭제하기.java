// arr배열을 돌면서, 해당 원소가 delete_list에 존재하는지 확인하고 
// 없다면 새로운 결과 배열 answer에 넣어줌.
// 배열로 하면 [293, 395, 0, 0] 이렇게 끝에 0이 생긴다.
import java.util.*;

class 배열의원소삭제하기 {
    public int[] solution(int[] arr, int[] delete_list) {
        // 배열의 길이는 arr보다 커질 수 없으므로, 크기를 arr과 같이 선언
        //int[] answer = new int[arr.length];
        List<Integer> answer = new ArrayList<>();
        
        for (int i:arr){
            if (!isExist(i, delete_list)){
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    public boolean isExist(int num, int[] list){
        for (int i: list){
            if (i == num){
                return true;
            }
        }
        return false;
    }
}