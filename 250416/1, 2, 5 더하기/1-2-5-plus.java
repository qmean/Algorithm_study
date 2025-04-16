import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] dp = new int[n+1];
        int[] num = {1, 2, 5};
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                int cur = num[j];
                if (i - cur > 0) {
                    dp[i] = (dp[i-cur] + dp[i]) % 10007;
                }
            }
        }
        System.out.println(dp[n]);
    }
}