import java.util.*;

public class Main {

    static int[] uf;
    static Edge[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        uf = new int[n];
        for (int i = 0; i < n; i++)
            uf[i] = i;
        
        int m = sc.nextInt();
        edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int value = sc.nextInt();
            
            edges[i] = new Edge(src, dest, value);
        }
        
        Arrays.sort(edges, (e1, e2) -> e1.value - e2.value);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            Edge cur = edges[i];

            if (union(cur.src, cur.dest)) {
                sum += cur.value;
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
        int value;

        public Edge(int s, int d, int v) {
            src = s;
            dest = d;
            value = v;
        }
    }
}