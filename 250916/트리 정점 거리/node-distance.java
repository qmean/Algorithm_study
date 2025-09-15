import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        int m = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int d = sc.nextInt();

            edges[u].add(new Edge(v, d));
            edges[v].add(new Edge(u, d));
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            Arrays.fill(visited, false);    
            System.out.println(dfs(u, v, 0));
        }

        
        
    }

    static int dfs(int idx, int dest, int value) {
        visited[idx] = true;
        
        if (idx == dest) {
            return value;
        }

        int sum = 0;
        for (Edge e : edges[idx]) {
            if (visited[e.idx])
                continue;
            sum += dfs(e.idx, dest, value + e.v);
        }

        return sum;
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