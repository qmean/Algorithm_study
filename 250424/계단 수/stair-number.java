import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[][] dp = new int[n+1][10];
        final int MOD = 1_000_000_007;
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                int b1 = j-1;
                int b2 = j+1;
                
                if (b1 >= 0) {
                    dp[i][j] += dp[i-1][b1];
                    dp[i][j] %= MOD;
                }

                if (b2 < 10) {
                    dp[i][j] += dp[i-1][b2];
                    dp[i][j] %= MOD;
                }
            }
        }

        int sum = 0;

        for(int i = 0; i < 10; i++) {
            sum += dp[n][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}