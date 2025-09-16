import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] edges;
    static int[] after;
    static int[] visited;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        edges = new ArrayList[n];
        after = new int[n];
        visited = new int[n];
        
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            
            edges[a].add(b);
            edges[b].add(a);
        }

        Arrays.fill(visited, -1);
        dfs(0, 0);
        int maxNode = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < visited[i]) {
                max = visited[i];
                maxNode = i;
            }
        }
        Arrays.fill(visited, -1);
        Arrays.fill(after , -1);
        ArrayList<Integer> path = new ArrayList<>();
        int dist = dfs(maxNode, 0);
        // System.out.println(dist);
        int cur = maxNode;
        while (cur != -1) {
            // System.out.print(cur + " ");
            path.add(cur);
            cur = after[cur];
        }
        // System.out.println();

        Arrays.fill(visited, -1);
        Arrays.fill(after , -1);
        int ans = Integer.MAX_VALUE;
        if (path.size() % 2 == 1) {
            int start = path.get(path.size() / 2);

            // System.out.println("start : " + start);

            ans = dfs(start, 0);
        } else {
            int c1 = path.get(path.size() / 2);
            int c2 = path.get(path.size() / 2 - 1);

            // System.out.println("c1 = " + c1);
            // System.out.println("c2 = " + c2);

            int v1 = dfs(c1, 0);
            Arrays.fill(visited, -1);
            Arrays.fill(after , -1);
            int v2 = dfs(c2, 0);
            ans = Math.min(v1,v2);
        }
        System.out.println(ans);
        // System.out.println((dist + 1) / 2);

    }

    static int dfs(int node, int value) {
        visited[node] = value;

        int nextIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int next : edges[node]) {
            if (visited[next] >= 0)
                continue;
            int nv = dfs(next, value + 1);
            if (max < nv) {
                max = nv;
                nextIdx = next;
            }
        }

        if (nextIdx == -1) {
            return value;
        } else {
            after[node] = nextIdx;
        }

        return max;
    }
}