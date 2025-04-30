import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Map<Character, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();

            Map<Character, Integer> tmpMap = new HashMap<>();
            for(int j = 0; j < word.length(); j++) {
                tmpMap.put(word.charAt(j), tmpMap.getOrDefault(word.charAt(j), 0) + 1);
            }
            map.put(tmpMap, map.getOrDefault(tmpMap, 0) + 1);
        }
        // Please write your code here.
        int max = 0;
        Set<Map.Entry<Map<Character, Integer>, Integer>> set = map.entrySet();
        for(Map.Entry<Map<Character, Integer>, Integer> e : set) {
            max = Math.max(max, e.getValue());
        }

        System.out.println(max);
    }
}