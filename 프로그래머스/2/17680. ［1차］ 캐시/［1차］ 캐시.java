import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        Map<String, Integer> set = new HashMap<>();
        TreeMap<Integer, String> map = new TreeMap<>();
        int time = 0;
        for(String data : cities) {
            String s = data.toLowerCase();
            if (set.containsKey(s)) {
                map.remove(set.get(s));
                map.put(time, s);
                set.remove(s);
                set.put(s, time);
                ans += 1;
            } else if (cacheSize == 0){
                ans += 5;
            } else {
                if (map.size() == cacheSize) {
                    String del = map.get(map.firstKey());
                    set.remove(del);
                    map.remove(map.firstKey());
                }
                set.put(s, time);
                map.put(time, s);
                ans+= 5;
            }
            // System.out.println(ans + " " + s);
            time++;
        }
        return ans;
    }
    
    public class Segment {
        String s;
        int t;
        
        public Segment(String s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}