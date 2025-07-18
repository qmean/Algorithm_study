import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            list.add(new Point(x1, 1));
            list.add(new Point(x2, -1));
        }
        list.sort((p1, p2) -> p1.x - p2.x);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Point p : list) {
            sum += p.v;
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static class Point {
        int x;
        int v;

        public Point(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }
}