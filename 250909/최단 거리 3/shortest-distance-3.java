import java.util.*;

public class Main {

    static int[] dp;
    static ArrayList<Segment>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dp = new int[n];
        edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            dp[i] = (int)1e9;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            int w = sc.nextInt();

            edges[u].add(new Segment(v, w));
            edges[v].add(new Segment(u, w));
        }
        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;

        dp[b] = 0;
        Queue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.v - s2.v);
        pq.add(new Segment(b, 0));

        while (!pq.isEmpty()) {
            Segment cur = pq.poll();
            int curIdx = cur.idx;
            int curValue = cur.v;

            if (dp[curIdx] != curValue)
                continue;
            
            for (Segment edge : edges[curIdx]) {
                int nextIdx = edge.idx;
                int newValue = edge.v + curValue;
                
                if (dp[nextIdx] > newValue) {
                    dp[nextIdx] = newValue;
                    pq.add(new Segment(nextIdx, newValue));
                }
            }
        }

        System.out.println(dp[a]);
    }

    static class Segment {
        int idx;
        int v;

        public Segment(int idx, int v){
            this.idx = idx;
            this.v = v;
        }
    }
}