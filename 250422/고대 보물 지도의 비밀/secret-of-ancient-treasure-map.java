import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[100001];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        long[][] dp = new long[100001][11];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        dp[0][0] = 0;
        // dp[a][b] = 마지막으로 a번째 숫자를 고르고 그 중 음수가 b개인 경우
        // 1. 새로운 수열을 만드는 경우
        // 음수라면 dp[a][1] 초기화
        // 양수라면 dp[a][0] 초기화
        // 2. 기존 수열에 현재 수를 붙이는 경우
        // arr[a] < 0 인 경우 -> dp[a][k'] = dp[a-1][k'-1] + arr[a] (1 <= k' <= k)
        // arr[a] > 0 인 경우 -> dp[a][k'] = dp[a-1][k'] + arr[a]
        long max = Long.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            boolean isNegative = arr[i] < 0;
            int sub = isNegative ? 1 : 0;
            // 새로운 수열 만듦
            dp[i][sub] = arr[i];
            for(int j = 0; j <= k; j++) {
                if (isNegative && j == 0)
                    continue;
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j - sub] + arr[i]);
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}