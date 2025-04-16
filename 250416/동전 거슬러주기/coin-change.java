import java.util.*;

public class Main {
    public static int[] dp;
    public static int[] coin;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        dp = new int[m + 1];
        coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        // Please write your code here.
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                int cur = coin[j];
                if (i - cur < 0)
                    continue;
                if (dp[i] < 0 && dp[i - cur] >= 0) {
                    dp[i] = dp[i - cur] + 1;
                } else if (dp[i - cur] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - cur] + 1);
                }
            }
        }

        // for(int i = 1; i <= m; i++) {
        //     System.out.println(dp[i]);
        // }
        System.out.println(dp[m]);
    }
}