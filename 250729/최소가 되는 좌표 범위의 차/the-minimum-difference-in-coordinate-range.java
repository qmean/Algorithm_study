import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        // int[] x = new int[n];
        // int[] y = new int[n];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }
        
        int min = Integer.MAX_VALUE;
        list.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        });
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        int a;
        int b = -1;
        int j = 0;
        for(int i = 0; i < n; i++) {
            Point ip = list.get(i);
            a = ip.x;
            ymax = Math.max(ymax, ip.y);
            ymin = Math.min(ymin, ip.y);
            // System.out.format("====== i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
            while(j < n && ymax - ymin < d) {
                // System.out.format("i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
                Point jp = list.get(j);
                ymax = Math.max(ymax, jp.y);
                ymin = Math.min(ymin, jp.y);
                j++;
            }
            b = list.get(j).x;
            if (ymax - ymin >= d && i != j) {
                // System.out.format("****** i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
                min = Math.min(Math.abs(b-a), min);
            }
        }

        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}