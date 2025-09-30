import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int idx = 1;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), idx);
            idx++;
        }
        int start = 0;
        while(msg.length() != 0) {
            for (int end = msg.length(); end > 0; end--) {
                String cur = msg.substring(start, end);
                if (map.containsKey(cur)) {
                    list.add(map.get(cur));
                    if (end < msg.length()) {
                        map.put(msg.substring(start, end + 1), idx);
                        idx++;
                    }
                    msg = msg.substring(end, msg.length());
                    break;
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}