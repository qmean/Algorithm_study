import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] red;
    static int[][] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();

        map = new int[n][n];
        ans = new int[n][n];
        red = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], (int)1e9);
            Arrays.fill(ans[i], (int)1e9);
            map[i][i] = 0;
        }

        for (int i = 0; i < P; i++) {
            ans[i][i] = 0;
            // red[i][i] = 0;
        }
            
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            if (u <= P || v <= P) {
                ans[u][v] = Math.min(ans[u][v], w);
            }
            map[u][v] = Math.min(map[u][v], w);
        }

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                    ans[j][k] = Math.min(ans[j][k], ans[j][i] + ans[i][k]);
                }
            }
        }

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                    if (i < P || j < P || k < P)
                        ans[j][k] = Math.min(ans[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        long cnt = 0L;
        long sum = 0L;
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            
            if (ans[x][y] != (int)1e9) {
                sum += ans[x][y];
                cnt += 1;
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(cnt);
        System.out.println(sum);
    }
}
