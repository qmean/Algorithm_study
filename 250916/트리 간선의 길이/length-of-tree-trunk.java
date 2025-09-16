import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int v = sc.nextInt();
            
            edges[a].add(new Edge(b, v));
            edges[b].add(new Edge(a, v));
        }

        dfs(0, 0);
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (visited[i] > max) {
                max = visited[i];
                maxIdx = i;
            }
        }

        Arrays.fill(visited, -1);
        dfs(maxIdx, 0);
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, visited[i]);
        }

        System.out.println(max);
    }

    static void dfs(int node, int value) {
        visited[node] = value;
        
        for (Edge e : edges[node]) {
            if (visited[e.idx] < 0) {
                dfs(e.idx, value + e.v);
            }
        }
    }

    static class Edge {
        int idx;
        int v;

        public Edge (int i, int v) {
            this.idx = i;
            this.v = v;
        }
    }
}