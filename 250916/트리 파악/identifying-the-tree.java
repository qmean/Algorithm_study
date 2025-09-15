import java.util.*;

public class Main {
    
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        depth = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[u].add(v);
            edges[v].add(u);
        }
        dfs(0, 0);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += depth[i];
        }

        if (sum % 2 == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int node, int d) {
        visited[node] = true;

        int cnt = 0;
        for(int i : edges[node]) {
            if (visited[i])
                continue;
            dfs(i, d + 1);
            cnt++;
        }

        if (cnt == 0) {
            depth[node] = d;
        }
    }
}