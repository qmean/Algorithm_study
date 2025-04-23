import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        final long MOD = 1_000_000_007;

        long[][][] dp = new long[n+1][3][3];

        // 모든 값 초기화
        for(int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // 채워넣기
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if (dp[i-1][j][k] < 0)
                        continue;
                    
                    // G 받는 경우
                    dp[i][0][k] = Math.max(dp[i-1][j][k], dp[i][0][k] + dp[i-1][j][k]);
                    dp[i][0][k] %= MOD;
                    
                    // B 받는 경우
                    if (j != 2) {
                        dp[i][j+1][k] = Math.max(dp[i-1][j][k], dp[i][j+1][k] + dp[i-1][j][k]);
                        dp[i][j+1][k] %= MOD;
                    }

                    // T 받는 경우
                    if (k != 2) {
                        dp[i][0][k+1] = Math.max(dp[i-1][j][k], dp[i][0][k+1] + dp[i-1][j][k]);
                        dp[i][0][k+1] %= MOD;
                    }
                }
            }
        }

        long sum = 0;
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
                if (dp[n][j][k] > 0)
                    sum += dp[n][j][k];
                // System.out.println(dp[n][j][k]);
            }
        }

        System.out.println(sum % MOD);
    }
}