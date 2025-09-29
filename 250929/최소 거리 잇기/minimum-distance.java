import java.util.*;

public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            uf[i] = i;
        }
        Queue<Edge> q = new PriorityQueue<>((e1, e2) -> (int)(e1.v - e2.v));
        for (int src = 0; src < n; src++) {
            for (int dest = 0; dest < n; dest++) {
                double value = Math.sqrt(Math.pow((double)Math.abs(points[src][0] - points[dest][0]), 2) + Math.pow((double)Math.abs(points[src][1] - points[dest][1]), 2));
                q.add(new Edge(src, dest, value));    
            } 
        }
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            union(src, dest);
            // double value = Math.sqrt(Math.pow((double)Math.abs(points[src][0] - points[dest][0]), 2) + Math.pow((double)Math.abs(points[src][1] - points[dest][1]), 2));
            // q.add(new Edge(src, dest, value));
        }
        double sum = 0;
        while(!q.isEmpty()) {
            Edge cur = q.poll();
            if (union(cur.a, cur.b)) {
                sum += cur.v;
            }
        }
        System.out.format("%.2f\n", sum);
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        return uf[f] = (find(uf[f]));
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br)
            return false;
        uf[ar] = br;
        return true;
    }

    static class Edge {
        int a;
        int b;
        double v;

        public Edge(int a, int b, double v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }
}