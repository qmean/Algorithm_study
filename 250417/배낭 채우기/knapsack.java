import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            int curw = w[i];
            int curv = v[i];
            for(int j = m; j >= curw; j--) {
                if (dp[j - curw] >= 0) 
                    dp[j] = Math.max(dp[j], dp[j- curw] + curv);
            }
        }

        int max = 0;
        for(int i = 1; i <= m; i++) {
            // System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}