import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[a][b] = a 번째에서 빨간색 카드를 b번 골랐을 때의 최댓값
        int[][] dp = new int[n*2 + 1][n+1];
        for(int i = 0; i <= 2 * n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= 2 * n; i++) {
            int red = sc.nextInt();
            int blue = sc.nextInt();
            // 빨간색 고르는 경우 업데이트
            for(int j = 1; j <= n; j++) {
                if (dp[i-1][j-1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + red);
                }
            }
            // 파란색 고르는 경우 업데이트
            for(int j = 0; j <= n; j++) {
                if (dp[i-1][j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + blue);
                }
            }
        }
        // Please write your code here.

        System.out.println(dp[n*2][n]);
    }
}