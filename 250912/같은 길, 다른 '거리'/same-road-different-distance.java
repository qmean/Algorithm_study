import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static ArrayList<Edge>[] edges2;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n];
        edges = new ArrayList[n];
        edges2 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            edges2[i] = new ArrayList<>();
        }
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int end = sc.nextInt() - 1;
            int start = sc.nextInt() - 1;
            int costA = sc.nextInt();
            int costB = sc.nextInt();

            Edge e = new Edge(start, end, costA, costB);
            edges[start].add(e);
            edges2[end].add(e);
        }
        
        for (int i = 0; i < n; i++) {
            int aMin = Integer.MAX_VALUE;
            int bMin = Integer.MAX_VALUE;
            for (Edge e : edges2[i]) {
                aMin = Math.min(e.ac, aMin);
                bMin = Math.min(e.bc, bMin);
            }
            for (Edge e : edges2[i]) {
                if (e.ac == aMin)
                    e.counter -= 1;
                if (e.bc == bMin)
                    e.counter -= 1;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println("====" + (i+1) + "====");
        //     for (Edge e : edges2[i])
        //         System.out.format("src = %d dest = %d counter = %d\n",e.idx+1, e.src+1, e.counter);
        // }
        
        Arrays.fill(dp, (int)1e9);
        dp[n-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
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
        int src;
        int ac;
        int bc;
        int counter = 2;

        public Edge(int src, int idx, int ac, int bc) {
            this.src = src;
            this.idx = idx;
            this.ac = ac;
            this.bc = bc;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.src == e.src && this.idx == e.idx && this.ac == e.ac && this.bc == e.bc)
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