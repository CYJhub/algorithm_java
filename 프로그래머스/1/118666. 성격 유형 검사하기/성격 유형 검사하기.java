import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new TreeMap<>();//<성격 유형:점수>
        
        for(int i=0;i<survey.length;i++){
            String[] arr = survey[i].split("");//비동의 동의
            String not_agree = arr[0];//비동의
            String agree = arr[1];//동의
            
            //비동의가 점수를 얻는 상황
            if(choices[i]<4){
                map.put(arr[0],map.getOrDefault(arr[0],0)+getScore(choices[i]));
            }
            //동의가 점수를 얻는 상황
            else if(choices[i]>4){
                map.put(arr[1],map.getOrDefault(arr[1],0)+getScore(choices[i]));
            }
            //둘다 점수를 얻지 못하는 상황 = 아무것도 하지 안해도 됨
            else if(choices[i]==4){
                continue;
            }
        
        }
        
        //R,T,C,F,J,M,A,N
        
            if(!map.containsKey("R")){
                map.put("R",0);
            }if(!map.containsKey("T")){
                map.put("T",0);
            }
            if(!map.containsKey("C")){
                map.put("C",0);
            }
            if(!map.containsKey("F")){
                map.put("F",0);
            }
            if(!map.containsKey("J")){
                map.put("J",0);
            }
            if(!map.containsKey("M")){
                map.put("M",0);
            }
            if(!map.containsKey("A")){
                map.put("A",0);
            }
            if(!map.containsKey("N")){
                map.put("N",0);
            }
            
        
        //System.out.println(map);
        StringBuilder sb = new StringBuilder();
        
        if(map.get("R")>=map.get("T")){
            sb.append("R");
        }else{
            sb.append("T");
        }
        if(map.get("C")>=map.get("F")){
            sb.append("C");
        }else{
            sb.append("F");
        }
        if(map.get("J")>=map.get("M")){
            sb.append("J");
        }else{
            sb.append("M");
        }
        if(map.get("A")>=map.get("N")){
            sb.append("A");
        }else{
            sb.append("N");
        }
        return sb.toString();
    }
    
    private static int getScore(int choice){
        if(choice==4){
            return 0;
        }
        else if(choice>4){
            return choice-4;
        }
        else if(choice<4){
            if(choice==1){
                return 3;
            }
            else if(choice==2){
                return 2;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}
//모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단
//같으면 사전 순으로 더 빠른 성격 유형을 선정한다.
//모든 알파벳에 대해서 없으면 value에 0을 추가

