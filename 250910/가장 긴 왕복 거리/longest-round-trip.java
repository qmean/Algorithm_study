import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() - 1;

        dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], (int)1e9);
        
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int v = sc.nextInt();
            
            edges[src].add(new Edge(dest, v));
        }
        
        for (int i = 0; i < n; i++)
            dijkstra(i, dp[i]);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[x][i] + dp[i][x]);
        }
        System.out.println(max);
    }

    static void dijkstra(int start, int[] dp) {
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(start, 0));

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