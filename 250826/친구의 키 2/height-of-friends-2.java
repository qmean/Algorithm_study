import java.util.*;

public class Main {

    static int[] indegree;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        indegree = new int[n+1];
        edges = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[b].add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int cnt = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for(int next : edges[cur]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    q.add(next);
            }
        }

        if (n != cnt) {
            System.out.println("Inconsistent");
        } else {
            System.out.println("Consistent");
        }
    }
}