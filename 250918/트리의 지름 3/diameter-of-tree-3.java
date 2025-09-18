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

        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxV < visited[i]) {
                maxV = visited[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (maxV == visited[i])
                list.add(i);
        }
        int idx = list.get(0);
        list.clear();
        Arrays.fill(visited , -1);
        dfs(idx, 0);
        for (int i = 0; i < n; i++) {
            pq.add(visited[i]);
        }
        
        int max = pq.poll();
        idx = -1;
        for (int i = 0; i < n; i++) {
            if (max == visited[i]) {
                idx = i;
                break;
            }
        }
        Arrays.fill(visited , -1);
        dfs(idx, 0);
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