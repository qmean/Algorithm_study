import java.util.*;

public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        uf = new int[n * m + 1];
        for (int i = 1; i <= n * m; i++)
            uf[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.v - e2.v);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m - 1; j++) {
                int v = sc.nextInt();
                int src = i * m + j;
                int dest = src + 1;
                pq.add(new Edge(src, dest, v));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= m; j++) {
                int v = sc.nextInt();
                int src = i * m + j;
                int dest = src + m;
                pq.add(new Edge(src, dest, v));
            }
        }


        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.src, cur.dest)) {
                sum += cur.v;
            }
        }
        
        System.out.println(sum);
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
        int src;
        int dest;
        int v;

        public Edge (int s, int d, int v) {
            this.src = s;
            this.dest = d;
            this.v = v;
        }
    }
}