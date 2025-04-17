import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                int c = coin[j];
                if (i - c >= 0 && dp[i - c] >= 0) {
                    dp[i] = Math.max(dp[i],dp[i-c] + 1);
                }
            }
        }
        System.out.println(dp[m]);
    }
}