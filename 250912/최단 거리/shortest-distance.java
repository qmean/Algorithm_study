import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], (int)1e9);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Math.min(matrix[j][i] + matrix[i][k], matrix[j][k]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(matrix[a[i]][b[i]]);
        }
    }
}