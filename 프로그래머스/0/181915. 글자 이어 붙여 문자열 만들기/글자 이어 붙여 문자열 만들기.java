class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        int len = index_list.length;
        String[] words = new String[len];
        
        for(int i=0;i<len;i++){
            words[i] = String.valueOf(my_string.charAt(index_list[i]));
        }
        
        answer = String.join("",words);
        
        return answer;
    }
}
// index_list를 돌며 원소를 뽑아 my_string에서 인덱스로 뽑음(단 이때 [] 가 아닌 .charAt()로 써야함.)
// 그래서 새로운 배열을 만든 다음에 .join으로 합쳐 문자열로 만든다.