import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Point(a, 1, i));
            list.add(new Point(b, -1, i));
        }
        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p2.v - p1.v;
            } else {
                return p1.x - p2.x;
            }
        });
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        int ans = 0;
        for (Point p : list) {
            if (p.v == 1) {
                if (set.isEmpty()) {
                    start = p.x;
                }
                set.add(p.idx);
            } else {
                set.remove(p.idx);
                if (set.isEmpty()) {
                    ans += p.x - start;
                }
            }
        }
        System.out.println(ans);
    }

    public static class Point {
        int x;
        int v;
        int idx;
        public Point(int x, int v, int idx) {
            this.x = x;
            this.v = v;
            this.idx = idx;
        }
    }
}