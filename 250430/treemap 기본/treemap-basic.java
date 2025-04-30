import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        SortedMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k, v);
            } else if (s.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            } else if (s.equals("find")) {
                int k = sc.nextInt();
                if (map.containsKey(k)) {
                    System.out.println(map.get(k));
                } else {
                    System.out.println("None");
                }
            } else {
                if (map.isEmpty()) {
                    System.out.println("None");
                    continue ;
                }
                Set<Map.Entry<Integer, Integer>> set = map.entrySet();
                for(Map.Entry<Integer, Integer> e : set) {
                    System.out.print(e.getValue() + " ");
                }
                System.out.println();
            }
        }
    }
}