import java.util.*;

public class Main {

    static int n;
    static int a;
    static int b;
    static char[][] brackets;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        brackets = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                brackets[i][j] = row.charAt(j);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dijkstra(i,j));
            }
        }

        System.out.println(max);
    }

    static int dijkstra(int x, int y) {
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (int)1e9);
        }

        dp[x][y] = 0;
        PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> s1.cost - s2.cost);
        pq.add(new Segment(x, y, 0, brackets[x][y]));

        while(!pq.isEmpty()) {
            Segment cur = pq.poll();
            
            if (dp[cur.x][cur.y] != cur.cost)
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                
                int ncost = cur.cost + (cur.value == brackets[nx][ny] ? a : b);

                if (dp[nx][ny] > ncost) {
                    dp[nx][ny] = ncost;
                    pq.add(new Segment(nx, ny, ncost, brackets[nx][ny]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    static class Segment {
        int x;
        int y;
        int cost;
        char value;

        public Segment(int x, int y, int cost, char value) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.value = value;
        }
    }
}