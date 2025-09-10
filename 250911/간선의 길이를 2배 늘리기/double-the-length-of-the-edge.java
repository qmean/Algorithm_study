import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int dp[];
    static int n;
    static Edge2[] candidate;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        candidate = new Edge2[m];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            
            edges[u].add(new Edge(v,w));
            edges[v].add(new Edge(u,w));

            candidate[i] = new Edge2(u, v, w);
        }

        dijkstra();
        int a = dp[n-1];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, process(i));
        }
        System.out.println(max - a);
    }

    static int process(int idx) {
        Edge2 edge2 = candidate[idx];
        Edge e1 = null;
        Edge e2 = null;
        for (Edge e : edges[edge2.i1]) {
            if (e.idx == edge2.i2)
                e1 = e;
        }
        for (Edge e : edges[edge2.i2]) {
            if (e.idx == edge2.i1)
                e2 = e;
        }
        e1.v *= 2;
        e2.v *= 2;
        
        dijkstra();

        e1.v /= 2;
        e2.v /= 2;

        return dp[n-1];
    }

    static void dijkstra() {
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dp[cur.idx] != cur.v)
                continue;
            
            for (Edge e : edges[cur.idx]) {
                int nv = e.v + cur.v;
                if (dp[e.idx] > nv) {
                    dp[e.idx] = nv;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }
    }

    static class Edge {
        int idx;
        int v;

        public Edge(int idx, int v){
            this.idx = idx;
            this.v = v;
        }
    }

    static class Edge2 {
        int i1;
        int i2;
        int v;
        
        public Edge2(int i1, int i2, int v) {
            this.i1 = i1;
            this.i2 = i2;
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