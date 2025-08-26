import java.util.*;

public class Main {

    static int[] indegree;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        n = 32001;
        edges = new ArrayList[32001];
        indegree = new int[32001];
        Arrays.fill(indegree, -1);

        for (int i = 1; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (indegree[a] == -1)
                indegree[a] = 0;
            if (indegree[b] == -1)
                indegree[b] = 0;
            edges[a].add(b);
            indegree[b]++;
        }
        
        Queue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 1; i < n; i++) {
            if (indegree[i] == 0)
                pq.add(i);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.print(cur + " ");
            
            for (int next : edges[cur]) {
                if (--indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println();
    }
}