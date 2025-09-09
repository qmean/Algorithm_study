import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static double[] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        dp = new double[n];
        Arrays.fill(dp, 1e10);

        int m = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int I = sc.nextInt() - 1;
            int J = sc.nextInt() - 1;
            int L = sc.nextInt();
            int C = sc.nextInt();

            edges[I].add(new Edge(J, L, C));
            edges[J].add(new Edge(I, L, C));
        }

        dp[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (int)(n1.cost - n2.cost));
        pq.add(new Node(0, 0, Integer.MAX_VALUE, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != dp[cur.idx])
                continue;
            
            for (Edge edge : edges[cur.idx]) {
                int dest = edge.dest;
                int newA = Math.min(edge.c, cur.a);
                int newB = cur.b + edge.l;
                double newCost = (double)newB + (double)x / newA;
                if (dp[dest] > newCost) {
                    dp[dest] = newCost;
                    pq.add(new Node(dest, newCost, newA, newB));
                }
            }
        }

        // System.out.format("%.0f\n", dp[n-1]);
        System.out.println((int)Math.floor(dp[n-1]));
    }

    static class Edge {
        int dest;
        int l;
        int c;

        public Edge (int dest, int l, int c) {
            this.dest = dest;
            this.l = l;
            this.c = c;
        }
    }

    static class Node {
        int idx;
        double cost;
        int b;
        int a;

        public Node(int idx, double cost, int a, int b) {
            this.idx = idx;
            this.cost = cost;
            this.a = a;
            this.b = b;
        }
    }
}

// C 값은 최솟값으로 하면서 L값의 합을 크게
// 필요한 시간 = B + X / A;