import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n+1][3];
        for(int i = 0; i < 3; i++) {
            dp[1][i] = data[1][i];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + data[i][j]);
                }
            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}