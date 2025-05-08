import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queries = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        Integer ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set.add(a);
            Integer min = set.lower(a);
            Integer max = set.higher(a);

            Integer l1 = min == null ? Integer.MAX_VALUE : Math.abs(min - a);
            Integer l2 = max == null ? Integer.MAX_VALUE : Math.abs(max - a);

            ans = Math.min(ans, l1);
            ans = Math.min(ans, l2);

            System.out.println(ans);
        }
    }
}