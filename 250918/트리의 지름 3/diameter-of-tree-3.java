import java.util.*;

public class Main {

    static ArrayList<Edge>[] edges;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        visited = new int[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();
        
        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int d = sc.nextInt();

            edges[u].add(new Edge(v, d));
            edges[v].add(new Edge(u, d));
        }

        Arrays.fill(visited , -1);
        dfs(0, 0);

        int maxIdx = -1;
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxV < visited[i]) {
                maxV = visited[i];
                maxIdx = i;
            }
        }

        Arrays.fill(visited , -1);
        dfs(maxIdx, 0);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(visited[i]);
        }  
        pq.poll();
        System.out.println(pq.poll());
    }

    static void dfs(int node, int v) {
        visited[node] = v;

        for(Edge e : edges[node]) {
            if (visited[e.idx] < 0) {
                dfs(e.idx, v + e.v);
            }
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