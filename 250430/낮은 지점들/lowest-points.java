import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (map.containsKey(x)) {
                if (map.get(x) > y) {
                    map.put(x,y);
                }
            } else {
                map.put(x,y);
            }
        }
        // Please write your code here.
        long sum = 0L;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> e : set) {
            sum += e.getValue();
        }

        System.out.println(sum);
    }
}