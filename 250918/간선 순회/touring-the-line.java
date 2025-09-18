import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] visited;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        visited = new int[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        int d = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
            sum += w * 2;
        }
        Arrays.fill(visited, -1);
        dfs(0, 0, 1);

        int maxIdx = -1;
        int minValue = Integer.MAX_VALUE;
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // System.out.format("idx = %d cnt = %d value = %d\n", i + 1, cnt[i], visited[i]);
            if (maxCnt < cnt[i]) {
                maxCnt = cnt[i];
                minValue = visited[i];
                maxIdx = i;
            } else if (maxCnt == cnt[i] && minValue > visited[i]) {
                minValue = visited[i];
                maxIdx = i;
            }
            // System.out.format("minvalue = %d maxcnt = %d maxidx = %d\n", minValue, maxCnt, maxIdx);
        }
        // System.out.println(maxIdx);
        Arrays.fill(visited, -1);
        Arrays.fill(cnt, 0);
        dfs(maxIdx, 0, 1);

        minValue = Integer.MAX_VALUE;
        maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // System.out.format("idx = %d cnt = %d value = %d\n", i + 1, cnt[i], visited[i]);
            if (maxCnt < cnt[i]) {
                maxCnt = cnt[i];
                minValue = visited[i];
            } else if (maxCnt == cnt[i]) {
                minValue = Math.min(minValue, visited[i]);
            }
        }
        sum = minValue;
        if (sum % d != 0) {
            System.out.println((sum / d + 1));
        } else {
            System.out.println(sum / d);
        }
    }

    static void dfs(int node, int v, int c) {
        visited[node] = v;
        cnt[node] = c;

        for (Edge e : edges[node]) {
            if (visited[e.idx] < 0) {
                dfs(e.idx, v + e.v, c + 1);
            }
        }
    }

    static class Edge {
        int idx;
        int v;

        public Edge(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }
}