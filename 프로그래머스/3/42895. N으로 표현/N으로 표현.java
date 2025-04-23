import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if(N == number){
            return 1;
        }
        
        List<Set<Integer>> countList  = new ArrayList<>();//크기가 고정되어 있을 필요가 없으므로 list
        for(int i=0;i<=8;i++){
            countList.add(new HashSet<>());
        }
        countList.get(1).add(N);//N하나로 만들 수 있는 수는 N뿐.
        for(int i=2;i<=8;i++){
            Set<Integer> countSet = countList.get(i);
            
            for(int j=1;j<=i;j++){
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);
                
                for(int preNum:preSet){
                    for(int postNum:postSet){
                        countSet.add(preNum+postNum);
                        countSet.add(preNum-postNum);
                        countSet.add(preNum*postNum);
                        
                        if(preNum != 0 && postNum != 0){
                            countSet.add(preNum / postNum);
                        }
					                
                    }
                }
            }
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            
        }
        for(Set<Integer> num: countList){
            if(num.contains(number)){
                return countList.indexOf(num);
            }
        }
        
        return answer;
    }
}
// 나누기 연산에서 나머지는 무시한다.
// 최솟값이 8보다 크면 -1을 반환