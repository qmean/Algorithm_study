import java.util.*;

public class Main {

    static ArrayList<Segment>[] edges;
    static int[] dp;
    static int[] src;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n];
        dp = new int[n];
        src = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            dp[i] = (int)1e9;
            src[i] = (int)1e9;
        }
        
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int z = sc.nextInt();

            edges[x].add(new Segment(y, z));
            edges[y].add(new Segment(x, z));
        }
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        dp[b] = 0;
        src[b] = b;
        
        PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.v - s2.v);
        pq.add(new Segment(b, dp[b]));

        while (!pq.isEmpty()) {
            Segment cur = pq.poll();
            int curIdx = cur.idx;
            int curValue = cur.v;
            
            if (curValue != dp[curIdx])
                continue;
            
            for (Segment edge : edges[curIdx]) {
                int nextIdx = edge.idx;
                int newValue = edge.v + curValue;

                if (dp[nextIdx] >= newValue) {
                    src[nextIdx] = Math.min(src[nextIdx], curIdx);
                    dp[nextIdx] = newValue;
                    pq.add(new Segment(nextIdx, newValue));
                }
            }
        }
        
        System.out.println(dp[a]);

        // for (int i = 0; i < n; i++) {
        //     System.out.println(src[i]);
        // }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(dp[i]);
        // }

        int curIdx = a;
        while (curIdx != b) {
            System.out.print((curIdx + 1) + " ");
            curIdx = src[curIdx];
        }
        System.out.println(b+1);
    }

    static class Segment {
        int idx;
        int v;

        public Segment(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }
}