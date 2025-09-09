import java.util.*;

public class Main {

    static ArrayList<Segment>[] edges;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        dp = new int[3][n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int val = sc.nextInt();
            
            edges[src].add(new Segment(dest, val));
            edges[dest].add(new Segment(src, val));
        }

        dijkstra(a, 0);
        dijkstra(b, 1);
        dijkstra(c, 2);

        int ans = Integer.MIN_VALUE;

        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < n; j++)
        //         System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }
        for (int i = 0; i < n; i++) {
            int minValue = Math.min(dp[0][i], dp[1][i]);
            minValue = Math.min(minValue, dp[2][i]);
            ans = Math.max(ans, minValue);
        }
        System.out.println(ans);
    }

    static void dijkstra(int start, int dpIdx) {
        Arrays.fill(dp[dpIdx], (int)1e9);
        dp[dpIdx][start] = 0;
        Queue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.v - s2.v);
        pq.add(new Segment(start, 0));

        while(!pq.isEmpty()) {
            Segment cur = pq.poll();
            int curIdx = cur.idx;
            int curValue = cur.v;

            if (dp[dpIdx][curIdx] != curValue)
                continue;

            for (Segment edge : edges[curIdx]) {
                int nextIdx = edge.idx;
                int newValue = edge.v + curValue;
                // System.out.format("next : %d new Value : %d curValue : %d", nextIdx, newValue, dp[nextIdx]);
                if (dp[dpIdx][nextIdx] > newValue) {
                    // System.out.println("update");
                    dp[dpIdx][nextIdx] = newValue;
                    pq.add(new Segment(nextIdx, newValue));
                }
            }
        }
    }

    static class Segment {
        int idx;
        int v;
        
        public Segment(int i, int v) {
            this.idx = i;
            this.v = v;
        }
    }
}