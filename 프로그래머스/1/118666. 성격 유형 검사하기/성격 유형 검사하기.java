import java.util.*;

class Solution {
    
    Map<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < choices.length; i++) {
            choices[i] -= 4;
        }
        for (int i = 0; i < choices.length; i++) {
            int score = choices[i];
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            if (score < 0) {
                map.put(c1, map.getOrDefault(c1, 0) + Math.abs(score));
            } else if (score > 0) {
                map.put(c2, map.getOrDefault(c2, 0) + Math.abs(score));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) {
            sb.append('A');
        } else {
            sb.append('N');
        }
        return sb.toString();
    }
}