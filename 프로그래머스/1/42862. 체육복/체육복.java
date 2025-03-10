import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 학생들을 번호 순서대로 저장한 리스트
        List<Integer> student = new ArrayList<>();
        for(int i=1;i<=n;i++){
            student.add(i);
        }
        List<Integer> lostL = new ArrayList<>();
        List<Integer> reserveL = new ArrayList<>();
        // 체육복 도난당한 학생들 리스트
        for(int i=0;i<lost.length;i++){
            lostL.add(lost[i]);
            // 체육복을 도난당하지 않은 학생들 리스트
            if(student.contains(lost[i])){
                student.remove(Integer.valueOf(lost[i]));
            }
        } 
        // 여분의 체육복이 있는 학생들 리스트
        for(int i=0;i<reserve.length;i++){
            reserveL.add(reserve[i]);
            // 여분의 체육복이 없는 학생들
            if(student.contains(reserve[i])){
                student.remove(Integer.valueOf(reserve[i]));
            }
        }
        // 지금까지student는 체육복이 오직 1벌만 있는 학생
        // 여분의 체육복이 있는 학생들 중 도난 당한 학생을 골라내기 위해
        for(int i=0;i<reserve.length;i++){
            if(lostL.contains(reserve[i])){//(reserve-lost) 
                lostL.remove(Integer.valueOf(reserve[i]));//************
                reserveL.remove(Integer.valueOf(reserve[i]));
                answer++;//여분의 체육복이 있는 학생들 중 도난 당한 학생=체육복 1한개=answer 하나 증가
            }
        }
        
        
        answer = answer + student.size() + reserveL.size();//체육복1개 있는 학생+2개있는 학생
        // n 명 중에 [1,2,3,4,5] lost reserve에 없는 사람의 수를 먼저 카운트
        // for(int i=0;i<student.size();i++){
        //     System.out.println(student.get(i));
        // }
        // for(int i=0;i<reserveL.size();i++){
        //     System.out.println(reserveL.get(i));
        // }
        
        //이제 진짜 없는 애들과 있는 애들만 남음
        // 있는 애들이 얼마나 빌려줄 수 있느냐만 더하면 됨.
        Collections.sort(lostL);
        Collections.sort(reserveL);
        for(int i=0;i<lostL.size();i++){
            if(reserveL.size()==0){
                break;
            }
            if(reserveL.contains(lostL.get(i)-1)){
                answer++;
                reserveL.remove(Integer.valueOf(lostL.get(i)-1));  
                continue;
            }
            else if(reserveL.contains(lostL.get(i)+1)){
                answer++;
                reserveL.remove(Integer.valueOf(lostL.get(i)+1));  
                continue;
            }
            
        }
    
        return answer;
    }
}
// 학생들의 번호는 체격순 바로 앞 뒤 학생한테만 빌려줄 수 있음.
// reserve 중에서도 도난 당했을 수 있다. 
// n 명 중에 [1,2,3,4,5] lost reserve에 없는 사람의 수를 먼저 카운트 + reserve^lost(교집합)
// 그리고 reserve 학생들 중 lost에 해당하지 않는 학생들은 판별 (reserve-lost) 
// 체육복이 지금 1개밖에 없는 학생 = n 명 중에 [1,2,3,4,5] lost reserve에 없는 사람의 수를 먼저 카운트 + reserve^lost(교집합)
// 체육복이 2개 있는 학생이 체육복이 없는 학생에게 빌려 줄 수 있는 경우의 수를 더하면 됨.