import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[1][1] = arr[1];
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                // 새롭게 집어넣는 경우 (새로운 구간 시작)
                if (j != 0) {
                    for(int k = 0; k <= i-2; k++) {
                        if (dp[k][j-1] == Integer.MIN_VALUE)
                            continue;
                        dp[i][j] = Math.max(dp[k][j-1] + arr[i], dp[i][j]);
                    }
                }
                // 원래 있던 거에서 붙이는 경우
                if (dp[i-1][j] == Integer.MIN_VALUE)
                    continue;
                dp[i][j] = Math.max(dp[i-1][j] + arr[i], dp[i][j]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i][m]);
        }
        System.out.println(ans);
    }
}