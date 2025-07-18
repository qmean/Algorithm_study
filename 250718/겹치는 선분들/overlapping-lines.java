import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] M = new int[n];
        char[] dir = new char[n];
        int before = 0;
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            M[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
            int start = before;
            int end;
            if (dir[i] == 'L') {
                end = start - M[i];
            } else {
                end = start + M[i];
            }
            list.add(new Point(Math.min(start, end), 1, i));
            list.add(new Point(Math.max(start, end), -1, i));
            before = end;
        }
        
        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p2.v - p1.v;
            } else {
                return p1.x - p2.x;
            }
        });

        int sum = 0;
        int ans = 0;
        int start = 0;
        HashSet<Integer> set = new HashSet<>();
        for(Point p : list) {
            // System.out.format("%d %d %d\n",p.x, p.v, p.idx);
            if (p.v == 1) {
                set.add(p.idx);
                if (set.size() == k) {
                    start = p.x;
                }
            } else {
                if (set.size() == k) {
                    ans += p.x - start;
                }
                set.remove(p.idx);
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