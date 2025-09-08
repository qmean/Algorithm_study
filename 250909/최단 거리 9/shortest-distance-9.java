import java.util.*;

public class Main {

    static ArrayList<Segment>[] edges;
    static int[] dp;
    static int[] src;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
    
        dp = new int[n];
        src = new int[n];
        edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            dp[i] = (int)1e9;
            src[i] = i;
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
        
        dp[a] = 0;
        src[a] = a;
        PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.v - s2.v);
        pq.add(new Segment(a, dp[a]));

        while (!pq.isEmpty()) {
            Segment cur = pq.poll();
            int curIdx = cur.idx;
            int curValue = cur.v;
            
            if (curValue != dp[curIdx])
                continue;
            
            for (Segment edge : edges[curIdx]) {
                int nextIdx = edge.idx;
                int newValue = edge.v + dp[curIdx];
                if (newValue < dp[nextIdx]) {
                    dp[nextIdx] = newValue;
                    src[nextIdx] = curIdx;
                    pq.add(new Segment(nextIdx, newValue));
                }
            }
        }

        // for (int i = 0; i < n; i++)
        //     System.out.println(src[i]);
        int curIdx = b;
        System.out.println(dp[b]);

        Deque<Integer> q = new ArrayDeque<>();
        while (curIdx != a) {
            q.add(curIdx);
            curIdx = src[curIdx];
        }
        q.add(a);
        while (!q.isEmpty()) {
            System.out.print((q.pollLast() + 1) + " ");
        }
        System.out.println();
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