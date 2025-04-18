import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        // Please write your code here.
        // 시간, 경험치 map
        SortedMap<Integer, Long> map = new TreeMap(Comparator.reverseOrder());
        map.put(0,0L);
        for(int i = 0; i < n; i++) {
            int t = time[i];
            int xp = exp[i];
            Object[] keys = map.keySet().toArray();
            for(int j = 0; j < keys.length; j++) {
                Integer key = (Integer)keys[j];
                map.put(key + t, Math.max(map.getOrDefault(key + t, 0L), map.getOrDefault(key, 0L) + xp));
            }
        }
        Set<Map.Entry<Integer,Long>> set = map.entrySet();
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Long> e : set) {
            // System.out.println(e.getKey() + " - " + e.getValue());
            if (e.getValue() >= m)
                min = Math.min(min,e.getKey());
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}