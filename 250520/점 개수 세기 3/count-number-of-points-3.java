import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (Integer i : set) {
            map.put(i, cnt);
            cnt++;
        }

        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(map.get(end) - map.get(start) + 1);
        }
        // Please write your code here.
    }
}