import java.util.*;

public class Main {
    
    static Set<Edge>[] edges;
    static Edge[][] map;
    static int[] dp;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        edges = new Set[n];
        map = new Edge[n][n];
        dp = new int[n];
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

        int primitive = dijkstra();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int src = i;
                int dest = j;
                if (map[src][dest] == null)
                    continue;
                edges[src].remove(map[src][dest]);
                edges[dest].remove(map[dest][src]);
                cnt += (dijkstra() == primitive ? 0 : 1);
                edges[src].add(map[src][dest]);
                edges[dest].add(map[dest][src]);
            }
        }

        System.out.println(cnt/2);
    }

    static int dijkstra() {
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(0,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (dp[cur.idx] != cur.v)
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.v + dp[cur.idx];
                if (dp[e.idx] > nv) {
                    dp[e.idx] = nv;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }
        return dp[n-1];
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