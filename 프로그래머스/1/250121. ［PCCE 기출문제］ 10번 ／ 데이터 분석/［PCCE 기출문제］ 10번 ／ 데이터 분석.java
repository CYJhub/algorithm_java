import java.util.*;

class Solution {
    static int num;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> result = new ArrayList<>();

        // ext 기준 필터링
        int extIndex = 0;
        if (ext.equals("code")) extIndex = 0;
        else if (ext.equals("date")) extIndex = 1;
        else if (ext.equals("maximum")) extIndex = 2;
        else if (ext.equals("remain")) extIndex = 3;

        for (int[] d : data) {
            if (d[extIndex] < val_ext) {
                result.add(d);
            }
        }

        // sort_by 기준 정렬
        num = 0;
        if (sort_by.equals("code")) num = 0;
        else if (sort_by.equals("date")) num = 1;
        else if (sort_by.equals("maximum")) num = 2;
        else if (sort_by.equals("remain")) num = 3;

        Collections.sort(result,(o1,o2)->Integer.compare(o1[num],o2[num]));

        // 리스트를 배열로 변환
        int[][] answer = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
