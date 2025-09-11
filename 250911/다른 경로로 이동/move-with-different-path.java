import java.util.*;

public class Main {

    static Set<Edge>[] edges;
    static Edge[][] map;
    static int[] path;
    static int[] dp;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n];
        path = new int[n];
        map = new Edge[n][n];
        edges = new Set[n];

        for (int i = 0; i < n; i++)
            edges[i] = new HashSet<>();

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            map[u][v] = new Edge(v, w);
            map[v][u] = new Edge(u, w);
            
            edges[u].add(map[u][v]);
            edges[v].add(map[v][u]);
        }

        Arrays.fill(path, (int)1e9);
        dijkstra();
        
        int cur = 0;
        while(cur != n-1) {
            // before -> cur
            int before = path[cur];
            edges[before].remove(map[before][cur]);
            edges[cur].remove(map[cur][before]);
            cur = before;
        }

        dijkstra();
        System.out.println(dp[0]);
    }

    static void dijkstra() {
        Arrays.fill(dp, (int)1e9);
        dp[n-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(n-1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.v != dp[cur.idx])
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.v + cur.v;
                if (dp[e.idx] == nv) {
                    if (path[e.idx] > cur.idx) {
                        path[e.idx] = cur.idx;
                        pq.add(new Node(e.idx, nv));
                    }
                } else if (dp[e.idx] > nv) {
                    dp[e.idx] = nv;
                    path[e.idx] = cur.idx;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }
    }

    static class Edge {
        int idx;
        int v;
        public Edge(int idx, int v) {
            this.idx = idx;
            this.v = v;
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
}