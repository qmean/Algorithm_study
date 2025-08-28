import java.util.Scanner;

public class Main {

    static int[][] graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = graph[u][v] == 0 ? w : Math.min(graph[u][v], w);
            graph[v][u] = graph[v][u] == 0 ? w : Math.min(graph[v][u], w);
        }
        
        for (int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }
        dist[n] = 0;

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            
            int minidx = -1;
            for (int j = 1; j <= n; j++) {
                if (visited[j])
                    continue;
                if (minidx == -1 || dist[minidx] > dist[j])
                    minidx = j;
            }
            visited[minidx] = true;
            ans += dist[minidx];
            for (int j = 1; j <= n; j++) {
                if (graph[minidx][j] == 0)
                    continue;
                dist[j] = Math.min(dist[j], graph[minidx][j]);
            }
        }

        System.out.println(ans);
    }
}