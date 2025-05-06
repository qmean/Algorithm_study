import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SortedMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        // Please write your code here.
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> e : set) {
            System.out.format("%s %d\n", e.getKey(), e.getValue());
        }
    }
}