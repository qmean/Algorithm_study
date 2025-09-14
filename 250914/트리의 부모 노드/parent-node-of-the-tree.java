import java.util.*;

public class Main {

    static ArrayList<Integer>[] edges;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new ArrayList[n];
        parent = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            edges[x].add(y);
            edges[y].add(x);
        }

        dfs(0);

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + 1);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (Integer i : edges[node]) {
            if (visited[i])
                continue;
            parent[i] = node;
            dfs(i);
        }
    }
}