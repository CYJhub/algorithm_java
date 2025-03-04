// class Solution {
//     public long solution(long n) {
//         long answer = 0;
//         boolean flag = false;
//         double num = Math.sqrt(n);
//         if(num - Math.floor(num)>0){
//             answer = -1;
//         }else{
//             answer = (long) ((num+1)*(num+1));
//         }
        
//         return answer;
//     }
// }

class Solution {
  public long solution(long n) {
      long answer = 0;

      for (long i = 1; i <= n; i++) {
          if (i * i == n) {
              answer = (i + 1) * (i + 1);
              break;
          }
          else answer = -1;
      }
      return answer;
  }
}