import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        int[][] score = {
            {1, 1, 1},    // 다이아 곡괭이
            {5, 1, 1},    // 철 곡괭이
            {25, 5, 1}    // 돌 곡괭이
        };
        
        // 1. 광물을 5개씩 자른 블록 생성
        List<String[]> blocks = new ArrayList<>();
        for(int i=0;i<minerals.length && blocks.size()<dia+iron+stone;i+=5){
            int end = Math.min(i+5,minerals.length);
            blocks.add(Arrays.copyOfRange(minerals, i, end));
        }
        
        // 2. 각 블록마다 돌곡괭이 기준 피로도 계산 (우선순위 판단용)
        List<Block> blockList = new ArrayList<>();
        for(String[] block : blocks){
            int total = 0;
            for (String m : block) {
                if (m.equals("diamond")) total += 25;
                else if (m.equals("iron")) total += 5;
                else total += 1;
            }
            blockList.add(new Block(block,total));
                
        }
        
        // 3. 블록을 피로도 기준으로 내림차순 정렬
        blockList.sort((a,b) -> b.totalFatigue - a.totalFatigue);
        
        // 4. 피로도가 높은 것부터 먼저 다이아 광물처리
        for (Block b : blockList){
            int tool = -1;
            if (dia > 0) {
                tool = 0; dia--;
            } else if (iron > 0) {
                tool = 1; iron--;
            } else if (stone > 0) {
                tool = 2; stone--;
            } else break;
            
            for(String m:b.minerals){
                switch(m){
                    case "diamond" -> answer += score[tool][0];
                    case "iron" -> answer += score[tool][1];
                    case "stone" -> answer += score[tool][2];
                    
                }
            }
        }

        return answer;
    }

    static class Block {
        String[] minerals;
        int totalFatigue;

        Block(String[] minerals, int totalFatigue) {
            this.minerals = minerals;
            this.totalFatigue = totalFatigue;
        }
    }
}
