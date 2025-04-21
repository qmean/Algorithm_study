import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n+1][4];
        dp[1][1] = coins[0];
        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-2][0] + coins[i-1];
            for(int j = 1; j <= 3; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-2][j]) + coins[i-1];
            }
        }

        int max = 0;
        for(int i = 0; i < 4; i++) {
            max = Math.max(max, dp[n][i]);
        }
        
        System.out.println(max);
    }
}
/*
dp[i][j] 로 정의
dp[i][j] = i 번째 계단에서 1계단 오르는 행동을 j번 했을 때의 코인의 최대 갯수
j = 0 1 2 3 까지 가능
i = 0 ~ N 까지 가능

점화식 dp[i][j] (1<= i <= N) && (0<= j <= 3)
dp[i][0] = dp[i-2][0] + coin[i];
dp[i][1] = max(dp[i-1][0] , dp[i-2][1]) + coin[i]
dp[i][2] = max(dp[i-1][1] , dp[i-2][2]) + coin[i]
dp[i][3] = max(dp[i-1][2] , dp[i-2][3]) + coin[i]
*/