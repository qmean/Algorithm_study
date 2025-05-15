import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int query = sc.nextInt();
            Integer find = set.floor(query);
            if (find != null) {
                System.out.println(find);
                set.remove(find);
            } else {
                System.out.println(-1);
            }
        }
        // Please write your code here.
    }
}