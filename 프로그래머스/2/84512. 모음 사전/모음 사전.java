class Solution {
    public int solution(String word) {
        int answer = word.length();
        String str= "AEIOU";
        int[] num = {781,156,31,6,1};//가중치
        
        for(int i=0;i<word.length();i++){
            int idx = str.indexOf(word.charAt(i));
            answer += num[i]*idx;
        }
        return answer;
    }
}
// {a,e,i,o,u,없음}
// "A"로 표현될 수 있는 모든 수의 개수 = 1*1*1*1*6, 1*1*1*6*6, 1*1*6*6*6, 1*6*6*6*6 = 1296
// "E"로 시작하는 표현될 수 모든 수의 개수 = 625
//1562/2 = 781

// A:1
// A_: 5
// A__: 5*5
//A___:5*5*5
//A____:5*5*5*5
// 다 더하면 781

//A____: 781
//AA___: 156
//AAA__: 31
//AAAA_:6
//AAAAA: 1