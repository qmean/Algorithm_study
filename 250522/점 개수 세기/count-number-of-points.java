import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        // Please write your code here.
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int idx = 1;
        for (Integer i : set) {
            map.put(i, idx);
            idx++;
        }

        for (int i = 0; i < Q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (map.ceilingKey(a) == null) {
                System.out.println(0);
                continue;
            }
            if (map.floorKey(b) == null) {
                System.out.println(0);
                continue;
            }
            int min = map.get(map.ceilingKey(a));
            int max = map.get(map.floorKey(b));

            System.out.println(max - min + 1);
        }
    }
}