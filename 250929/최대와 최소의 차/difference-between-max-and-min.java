import java.util.*;

public class Main {
    
    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int m = sc.nextInt();
        Queue<Edge> pq1 = new PriorityQueue<>((e1, e2) -> e2.t - e1.t);
        Queue<Edge> pq2 = new PriorityQueue<>((e1, e2) -> e1.t - e2.t);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int type = sc.nextInt();
            pq1.add(new Edge(u, v, type));
            pq2.add(new Edge(u, v, type));
        }

        int min = 0;
        while (!pq1.isEmpty()) {
            Edge cur = pq1.poll();
            if (union(cur.a, cur.b)) {
                min += (1 - cur.t);
            }
        }

        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        int max = 0;
        while (!pq2.isEmpty()) {
            Edge cur = pq2.poll();
            if (union(cur.a, cur.b)) {
                max += (1 - cur.t);
            }
        }
        

        System.out.println((long)(Math.pow(max, 2) - Math.pow(min, 2)));
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        return uf[f] = find(uf[f]);
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
        int t;

        public Edge(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
    }
}