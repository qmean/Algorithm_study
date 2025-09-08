import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n];
        dist = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = (int)1e9;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();

            edges[b].add(new Edge(a, d));
        }

        dist[n-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
        pq.add(new Node(n-1, dist[n-1]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curValue = cur.v;

            if (dist[curIdx] != curValue)
                continue;
            
            for (Edge e : edges[curIdx]) {
                int nextIdx = e.idx;
                int edgeValue = e.v;
                
                int nv = edgeValue + curValue;
                if (dist[nextIdx] > nv) {
                    dist[nextIdx] = nv;
                    pq.add(new Node(nextIdx, nv));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            if (dist[i] == (int)1e9)
                continue;
            max = Math.max(max, dist[i]);
        }
        System.out.println(max);
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