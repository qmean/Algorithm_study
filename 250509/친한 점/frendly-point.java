import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Pair> set = new TreeSet<>((p1, p2) -> {
            if (p1.x != p2.x) {
                return p1.x - p2.x;
            } else {
                return p1.y - p2.y;
            }
        });
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            set.add(Pair.of(x,y));
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair p = Pair.of(x,y);
            if (set.higher(p) != null) {
                Pair ans = set.higher(p);
                System.out.println(ans.x + " " + ans.y);
            } else {
                System.out.println("-1 -1");
            }
        }
    }

    public static class Pair {
        int x;
        int y;

        public static Pair of(int x, int y) {
            Pair p = new Pair();
            p.x = x;
            p.y = y;
            return p;
        }
    }
}