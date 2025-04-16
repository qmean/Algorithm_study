import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here
        int[] dp = new int[m+1];
        Arrays.fill(dp, m);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            int cur = arr[i];
            for(int j = m; j >= cur; j--) {
                if (dp[j - cur] >= 0) {
                    dp[j] = Math.min(dp[j - cur] + 1, dp[j]);
                }
            }
        }

        int ans = dp[m] == m ? -1 : dp[m];
        System.out.println(ans);
    }
}