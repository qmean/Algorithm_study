import java.util.*;

public class Main {
    
    static Deque<Integer> stack = new ArrayDeque<>();
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[b].add(a);
        }

        for (int i = 1; i < n+1; i++) {
            if (!visited[i])
                dfs(i);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
        System.out.println();
    }

    static void dfs(int cur) {
        visited[cur] = true;
        for(int i : edges[cur]) {
            if (!visited[i])
                dfs(i);
        }
        stack.addLast(cur);
    }

}