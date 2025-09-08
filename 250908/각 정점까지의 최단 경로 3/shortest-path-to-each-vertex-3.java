import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n];
        dp = new int[n];
        
        for (int i = 0; i < n; i++)
            dp[i] = (int)1e9;

        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            
            map[u][v] = w;
        }

        for (int i = 0; i < n; i++) {
            int idx = -1;
            int minValue = (int)1e9;
            for (int j = 0; j < n; j++) {
                if (visited[j])
                    continue;
                if (idx == -1 || minValue > dp[j]) {
                    idx = j;
                    minValue = dp[j];
                }
            }

            for (int j = 0; j < n; j++) {
                if (map[idx][j] == 0)
                    continue;
                dp[j] = Math.min(dp[j], map[idx][j] + dp[idx]);
            }
            visited[idx] = true;
        }

        for (int i = 1; i < n; i++) {
            if (dp[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(dp[i]);
        }
    }
}