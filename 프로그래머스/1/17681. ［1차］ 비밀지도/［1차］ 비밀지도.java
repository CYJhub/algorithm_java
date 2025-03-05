import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        ArrayList<String> lst1 = new ArrayList<>();
        ArrayList<String> lst2 = new ArrayList<>();
        String str = Integer.toBinaryString(arr1[0]);
        for(int i=0;i<n;i++){
            String temp = Integer.toBinaryString(arr1[i]);
            
            while(temp.length()<n){
                temp = "0"+temp;
            }
            lst1.add(temp);//이진화한 값을 넣을 배열
        }
        
        for(int i=0;i<n;i++){
            String temp = Integer.toBinaryString(arr2[i]);
            
            while(temp.length()<n){
                temp = "0"+temp;
            }
            lst2.add(temp);//이진화한 값을 넣을 배열
        }
        //System.out.println(lst1.get(4));
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(lst1.get(i).charAt(j)=='0'&&lst2.get(i).charAt(j)=='0'){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            System.out.println(sb.toString());
            answer[i] = sb.toString();

        }

        return answer;
    }
}
// 둘다 0이어야 " ", 하나라도 1이면 #
// 10진수를 2진수로 변환 -> 1을 #(벽), 0을 " "(공백)으로 가정
// 지도 2개의 같은 인덱스에 있는 값을 비교하여 공백+공백=공백&벽이 하나라도 있으면 벽으로 출력
// 9%2=1,9/2=4,4%2=0,2%2=0,1%2=1,1/2=0