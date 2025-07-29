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
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            Point ip = list.get(i);
            a = ip.x;
            set.add(ip.y);
            // System.out.format("====== i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
            while(j < n && set.last() - set.first() < d) {
                // System.out.format("i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
                Point jp = list.get(j);
                set.add(jp.y);
                b = jp.x;
                j++;
            }
            if (set.last() - set.first() >= d && set.size() != 1) {
                // System.out.format("****** i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
                // b = list.get(j).x;
                min = Math.min(Math.abs(b-a), min);
            }
            set.remove(ip.y);
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