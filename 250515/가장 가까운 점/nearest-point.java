import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        PriorityQueue<Point> q = new PriorityQueue<>((p1, p2) -> {
            long l1 = p1.x * p1.x + p1.y * p1.y;
            long l2 = p2.x * p2.x + p2.y * p2.y;
            if (l1 < l2) {
                return -1;
            } else if (l1 > l2) {
                return 1;
            } else {
                if (p1.x != p2.x) {
                    return (int)p1.x - (int)p2.x;
                } else {
                    return (int)p1.y - (int)p2.y;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            q.add(new Point(x, y));
        }
        // Please write your code here.
        for (int i = 0; i < m; i++) {
            Point p = q.poll();
            p.x += 2;
            p.y += 2;
            q.add(p);
        }

        Point p = q.poll();

        System.out.println(p.x + " " + p.y);
    }

    public static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}