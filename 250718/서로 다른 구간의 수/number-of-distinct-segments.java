import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            arr.add(new Point(a[i], 1, i));
            arr.add(new Point(b[i], -1, i));
        }
        arr.sort((p1, p2) -> {
            return p1.x - p2.x;
        });

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        for(Point p : arr) {
            // System.out.format("%d %d %d\n", p.x, p.v, p.idx);
            if (p.v == 1) {
                if (set.isEmpty()) {
                    sum+=1;
                }
                set.add(p.idx);
            } else {
                set.remove(p.idx);
            }
        }

        System.out.println(sum);
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