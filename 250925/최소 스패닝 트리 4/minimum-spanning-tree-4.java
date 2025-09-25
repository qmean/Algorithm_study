import java.util.*;

public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] types = new char[n];
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = sc.next().charAt(0);
            uf[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.value - e2.value);
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;
            int v = sc.nextInt();
            if (types[s] == types[d])
                continue;
            pq.add(new Edge(s, d, v));
        }

        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.src, cur.dest)) {
                cnt++;
                sum += cur.value;
            }
        }
        
        System.out.println((cnt == n-1 ? sum : -1));
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
        int value;

        public Edge(int s, int d, int v) {
            src = s;
            dest = d;
            value = v;
        }
    }
}