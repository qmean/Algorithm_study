import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static boolean[] visited;
    static int[] dp;
    static int max = Integer.MIN_VALUE;
    static int maxIdx = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        edges = new ArrayList[n];

        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        visited = new boolean[n];
        dp = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }


        dfs(0, 0);

        max = Integer.MIN_VALUE;
        Arrays.fill(visited, false);
        dfs(maxIdx, 0);
        
        System.out.println(max);
    }

    static void dfs(int idx, int value) {
        visited[idx] = true;
        
        for (Edge e : edges[idx]) {
            int nextIdx = e.idx;
            int nv = value + e.v;
            if (visited[nextIdx])
                continue;
            dfs(nextIdx, nv);
        }

        if (max < value) {
            max = value;
            maxIdx = idx;
        }
    }

    static class Edge {
        int idx;
        int v;

        public Edge (int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }
}