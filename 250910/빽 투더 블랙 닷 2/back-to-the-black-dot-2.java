import java.util.*;
public class Main {

    static ArrayList<Edge>[] edges;
    static int[] red1dp;
    static int[] red2dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        red1dp = new int[n];
        red2dp = new int[n];
        Arrays.fill(red1dp, (int)1e9);
        Arrays.fill(red2dp, (int)1e9);
        
        int m = sc.nextInt();
        int red1 = sc.nextInt() - 1;
        int red2 = sc.nextInt() - 1;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }

        red1dp[red1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);
        pq.add(new Node(red1, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (red1dp[cur.idx] != cur.value)
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.value + cur.value;
                if (red1dp[e.idx] > nv) {
                    red1dp[e.idx] = nv;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }

        red2dp[red2] = 0;
        pq.clear();
        pq.add(new Node(red2, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (red2dp[cur.idx] != cur.value)
                continue;

            for (Edge e : edges[cur.idx]) {
                int nv = e.value + cur.value;
                if (red2dp[e.idx] > nv) {
                    red2dp[e.idx] = nv;
                    pq.add(new Node(e.idx, nv));
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(red1dp[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     System.out.print(red2dp[i] + " ");
        // }
        // System.out.println();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == red1 || i == red2)
                continue;
            if (red1dp[i] == (int)1e9 || red2dp[i] == (int)1e9)
                continue;
            int red1v = red1dp[i];
            int red2v = red2dp[i];
            int redv = red1dp[red2];
            
            // source -> red1 -> red2 -> source
            int v1 = red1v + redv + red2v;
            // source -> red1 -> source -> red2 -> source
            int v2 = 2 * red1v + 2 * red2v;
            int curMin = Math.min(v1, v2);
            min = Math.min(min, curMin);
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else 
            System.out.println(min);
    }

    static class Edge {
        int idx;
        int value;

        public Edge(int i, int v) {
            idx = i;
            value = v;
        }
    }

    static class Node {
        int idx;
        int value;

        public Node(int i, int v) {
            idx = i;
            value = v;
        }
    }
}

// 빨 - 빨 사이 거리 최소
// 검 - 빨1 + 검 - 빨2 사이 거리 최소
// 더하여 답 구하기