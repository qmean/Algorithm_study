import java.util.*;

public class Main {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        map = new int[n][n];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(map[i], (int)1e9);
        
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int value = sc.nextInt();
            map[src][dest] = Math.min(map[src][dest], value);
        }

        for (int i = 0; i < n; i++)
            map[i][i] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == (int)1e9)
                    System.out.print(-1 + " ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}