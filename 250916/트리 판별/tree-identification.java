import java.util.*;
public class Main {

    static ArrayList<Integer>[] edges;
    static int[] indegree;
    static boolean[] visited;
    static Set<Integer> nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        
        edges = new ArrayList[10000];
        indegree = new int[10000];
        visited = new boolean[10000];
        nodes = new HashSet<>();

        for (int i = 0; i < 10000; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            nodes.add(a);
            nodes.add(b);
            edges[a].add(b);
            indegree[b]++;
        }

        int root = -1;
        int rootCnt = 0;
        for (int i = 0; i < 10000; i++) {
            if (indegree[i] == 0 && edges[i].size() == 0) {
                continue ;
            } else if (indegree[i] == 0 && edges[i].size() != 0) {
                root = i;
                rootCnt++;
            } else if (indegree[i] >= 2) {
                // System.out.println("indegree >= 2");
                System.out.println(0);
                return;
            }
        }
        
        if (rootCnt != 1) {
            // System.out.println("root cnt != 1");
            System.out.println(0);
            return;
        }

        dfs(root);

        int cnt = 0;
        for (int i = 0; i < 10000; i++) {
            if (visited[i])
                cnt++;
        }

        if (cnt != nodes.size()) {
            System.out.println(0);
            return ;
        }

        System.out.println(1);
    }

    static void dfs(int node) {
        visited[node] = true;
        
        for (int i : edges[node]) {
            if (!visited[i])
                dfs(i);
        }
    }
}