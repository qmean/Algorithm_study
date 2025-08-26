import java.util.*;

public class Main {

    static Queue<Integer> print = new PriorityQueue<>();
    static int[] ndegree;
    static ArrayList<Integer>[] edges;
    static boolean[] have;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n+1];
        ndegree = new int[n+1];
        have = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int part = sc.nextInt();
                edges[part].add(a);
                ndegree[a]++;
            }
        }

        int parts = sc.nextInt();
        for (int i = 0; i < parts; i++) {
            int x = sc.nextInt();
            have[x] = true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (ndegree[i] == 0 && have[i])
                q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            print.add(cur);

            for(int next : edges[cur]) {
                ndegree[next]--;
                if (ndegree[next] == 0) {
                    have[next] = true;
                    q.add(next);
                }
            }
        }

        System.out.println(print.size());
        while(!print.isEmpty()) {
            System.out.print(print.poll() + " ");
        }
        System.out.println();
    }
}