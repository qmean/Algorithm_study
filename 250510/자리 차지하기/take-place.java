import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= m; i++) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            Integer b = set.floor(a);
            if (b == null) {
                System.out.println(i-1);
                return;
            }
            set.remove(a);
        }
        System.out.println(n);
    }
}