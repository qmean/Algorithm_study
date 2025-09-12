import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int costA = sc.nextInt();
            int costB = sc.nextInt();

            edges[src].add(new Edge(src, dest, costA, costB));
        }
        
        for (int i = 0; i < n; i++) {
            int aMin = Integer.MAX_VALUE;
            int bMin = Integer.MAX_VALUE;
            for (Edge e : edges[i]) {
                aMin = Math.min(e.ac, aMin);
                bMin = Math.min(e.bc, bMin);
            }
            for (Edge e : edges[i]) {
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
        dp[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dp[cur.idx] != cur.v) continue;

            for (Edge e : edges[cur.idx]) {
                int nv = cur.v + e.counter;
                if (dp[e.dest] > nv) {
                    dp[e.dest] = nv;
                    pq.add(new Node(e.dest, nv));
                }
            }
        }
        
        System.out.println(dp[n-1]);
    }

    static class Edge {
        int src;
        int dest;
        int ac;
        int bc;
        int counter = 2;

        public Edge(int src, int dest, int ac, int bc) {
            this.src = src;
            this.dest = dest;
            this.ac = ac;
            this.bc = bc;
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