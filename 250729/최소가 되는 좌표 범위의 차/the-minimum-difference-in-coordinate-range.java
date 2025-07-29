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
            return p1.y - p2.y;
            // if (p1.x == p2.x) {
            //     return p1.y - p2.y;
            // }
            // return p1.x - p2.x;
        });
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        int a;
        int b = -1;
        int j = 1;
        TreeSet<Point> set = new TreeSet<>((p1, p2) -> {
            if (p1.y == p2.y) {
                return p1.x - p2.x;
            }
            return p1.y - p2.y;
        });
        for(int i = 0; i < n; i++) {
            Point ip = list.get(i);
            a = ip.x;
            set.add(ip);
            // System.out.format("====== i : %d j : %d ymax : %d ymin : %d\n", i, j, ymax, ymin);
            while(j < n && set.last().y - set.first().y < d) {
                Point jp = list.get(j);
                set.add(jp);
                // System.out.format("i : %d j : %d ymax : %d ymin : %d\n", i, j, map.firstKey(), map.lastKey());
                b = jp.x;
                j++;
            }
            if (set.last().y - set.first().y >= d && set.size() != 1) {
                // System.out.println(a + " " + b);
                // System.out.format("===== i : %d j : %d ymax : %d ymin : %d\n", i, j, map.firstKey(), map.lastKey());
                min = Math.min(Math.abs(b-a), min);
            }
            
            set.remove(ip);
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