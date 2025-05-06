import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (!map.containsKey(cur))
                map.put(cur, i+1);
        }
        // Please write your code here.
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> e : set) {
            System.out.format("%d %d\n", e.getKey(), e.getValue());
        }
    }
}