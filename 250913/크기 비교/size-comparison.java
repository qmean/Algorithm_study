import java.util.*;

public class Main {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 10);
            map[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            // a - b > 0 b - a < 0
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            map[a][b] = 1;
            map[b][a] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][i] == 10 || map[i][k] == 10)
                        continue;
                    if ((map[j][i] * map[i][k]) > 0) {
                        map[j][k] = map[j][i];
                    } else if ((map[j][i] * map[i][k]) == 0) {
                        if (map[j][i] == 0) {
                            map[j][k] = map[i][k];
                        } else {
                            map[j][k] = map[j][i];
                        }
                    }
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += (map[i][j] != 10 ? 0 : 1);
            }
            System.out.println(cnt);
        }
    }
}

// j -> i , i -> k
//  -1 -1 => 안됨
//  -1 +1 => 가능 => k > i > j 이므로 map[j][k] = -1 
//  +1 -1 => 가능 => j > i > k 이므로 map[j][k] = 1
//  0  +1 => 가능 => j == i > k
//  1  0  => 가능 => j > i == k
//  +1 +1 => 안됨