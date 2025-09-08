import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;

        edges = new ArrayList[n];
        dist = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            dist[i] = (int)1e9;

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        dist[k] = 0;
        pq.add(new Node(k, dist[k]));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.v != dist[cur.idx])
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.v + dist[cur.idx];
                if (dist[e.to] > nv) {
                    dist[e.to] = nv;
                    // System.out.println("cur = idx : " + cur.idx + " value : " + cur.v);
                    // System.out.println("to = idx : " + e.to + " dist : " + dist[e.to]);
                    pq.add(new Node(e.to, nv));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }
    }

    static class Node {
        int idx;
        int v;

        public Node(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }

    static class Edge {
        int to;
        int v;

        public Edge(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }
}