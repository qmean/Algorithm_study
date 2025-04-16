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
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (dp(m) == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[m]);
    }

    public static int dp(int m) {
        for(int i = 0; i < coin.length; i++) {
            if (m - coin[i] >= 0) {
                if (dp(m - coin[i]) != Integer.MAX_VALUE) {
                    dp[m] = Math.min(dp(m- coin[i])+1, dp[m]);
                }
            }
        }
        return dp[m];
    }
}