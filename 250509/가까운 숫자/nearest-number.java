import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queries = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set.add(a);
            Integer min = set.lower(a);
            Integer max = set.higher(a);

            Integer l1 = min == null ? Integer.MAX_VALUE : Math.abs(min - a);
            Integer l2 = max == null ? Integer.MAX_VALUE : Math.abs(max - a);

            Sysetm.out.println(Math.min(l1, l2));
        }
        // Please write your code here.
    }
}