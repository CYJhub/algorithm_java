class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] cal = new int[3];//다트 각 기회 하나당 얻을 수 있는 점수를 저장하는 배열
        int idx = -1;
        char[] arr = dartResult.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '1' && arr[i+1] == '0'){//10이라면 
                idx++;
                cal[idx] = 10;//(int) dart; 명시적 형변환 10대입
                i++; // 인덱스 하나 더 증가
                System.out.println(cal[idx]);
                continue;
            }
            else if (arr[i]>='0' && arr[i]<='9'){
                idx++;
                cal[idx] = arr[i]-'0';
                System.out.println(cal[idx]);
                continue;
            }
            
            switch (arr[i]){
                case 'D':
                    cal[idx] *= cal[idx];
                    break;
                case 'T':
                    cal[idx] *= (cal[idx] * cal[idx]);
                    break;
                case '*':
                    cal[idx] *= 2;
                    if(idx - 1>=0){
                        cal[idx-1] *= 2;
                    }
                    break;
                case '#':
                    cal[idx] *= (-1);
            }
            
        }
        for(int num:cal){
            answer += num;
            System.out.println(num);
        }
        return answer;
    }
}
// 다트 기회는 3번!!
// 문자열을 돌면서 해당 문자가 숫자인지, <S,D,T> 인지, <*,#>인지 구별