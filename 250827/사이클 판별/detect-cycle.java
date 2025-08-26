import java.util.*;

public class Main {
    
    static int[] degree;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        degree = new int[n+1];
        edges = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[b].add(a);
            degree[a]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : edges[cur]) {
                if (--degree[next] == 0)
                    q.add(next);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] != 0) {
                System.out.println("Exists");
                return ;
            }
        }

        System.out.println("Not Exists");
    }
}