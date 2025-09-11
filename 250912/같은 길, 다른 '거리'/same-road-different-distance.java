import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static Set<Edge>[] toA;
    static Set<Edge>[] toB;
    static int[] dp;
    static int[][] warn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n];
        warn = new int[n][n];
        toA = new HashSet[n];
        toB = new HashSet[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            toA[i] = new HashSet<>();
            toB[i] = new HashSet<>();
            edges[i] = new ArrayList<>();
        }
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int end = sc.nextInt() - 1;
            int start = sc.nextInt() - 1;
            int costA = sc.nextInt();
            int costB = sc.nextInt();

            edges[start].add(new Edge(end, costA, costB));
        }
        
        Arrays.fill(dp, (int)1e9);
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        dp[n-1] = 0;
        pq.add(new Node(n-1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dp[cur.idx] != cur.v)
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.ac + cur.v;
                if (dp[e.idx] >= nv) {
                    dp[e.idx] = nv;
                    if (dp[e.idx] != nv) {
                        toA[e.idx].clear();
                    }
                    toA[cur.idx].add(e);
                    pq.add(new Node(e.idx, nv));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (Edge e : toA[i]) {
                e.counter = e.counter - 1;
                // System.out.println(e.counter);
            }
        }

        Arrays.fill(dp, (int)1e9);
        dp[n-1] = 0;
        pq.add(new Node(n-1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dp[cur.idx] != cur.v)
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.bc + cur.v;
                if (dp[e.idx] >= nv) {
                    dp[e.idx] = nv;
                    if (dp[e.idx] != nv) {
                        toB[e.idx].clear();
                    }
                    toB[e.idx].add(e);
                    pq.add(new Node(e.idx, nv));
                }
            }
        }
        
        // System.out.println();
        for (int i = 0; i < n; i++) {
            for (Edge e : toB[i]) {
                e.counter = e.counter - 1;
                // System.out.println(e.counter);
            }
        }

        dp[n-1] = 0;
        pq.add(new Node(n-1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dp[cur.idx] != cur.v) continue;

            for (Edge e : edges[cur.idx]) {
                int nv = cur.v + e.counter;
                if (dp[e.idx] > nv) {
                    dp[e.idx] = nv;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }

        System.out.println(dp[0]);
    }

    static class Edge implements Comparable<Edge> {
        int idx;
        int ac;
        int bc;
        int counter = 2;

        public Edge(int idx, int ac, int bc) {
            this.idx = idx;
            this.ac = ac;
            this.bc = bc;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.idx == e.idx && this.ac == e.ac && this.bc == e.bc)
                return 0;
            return 1;
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