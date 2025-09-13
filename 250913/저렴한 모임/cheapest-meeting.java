import java.util.*;

public class Main {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], (int)1e9);
            map[i][i] = 0;
        }

        int m = sc.nextInt();
        int v1 = sc.nextInt() - 1;
        int v2 = sc.nextInt() - 1;
        int e = sc.nextInt() - 1;
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int val = sc.nextInt();

            map[src][dest] = Math.min(map[src][dest], val);
            map[dest][src] = Math.min(map[dest][src], val);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int min = (int)1e9;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, map[v1][i] + map[v2][i] + map[i][e]);
        }
        if (v1 == v2) {
            min = map[v1][e];
        }

        if (min == (int)1e9) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}