import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        dp = new int[n];
        
        Arrays.fill(dp, (int)1e9);
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int val = sc.nextInt();
            
            edges[src].add(new Edge(dest, val));
            edges[dest].add(new Edge(src, val));
        }

        dp[n-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(n-1, 0));

        while (!pq.isEmpty()) {
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
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
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
        int idx;
        int v;

        public Edge(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }
}