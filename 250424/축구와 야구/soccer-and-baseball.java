import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soccer = new int[N+1];
        int[] baseball = new int[N+1];
        for (int i = 1; i <= N; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }
        // Please write your code here.

        // 3가지 케이스
        // 1. 축구 팀으로 뽑는 경우
        // 2. 야구 팀으로 뽑는 경우
        // 3. 뽑지 않는 경우

        // dp[a][b][c] a까지 고려했을때 축구팀 b 야구팀 c 명을 뽑는 경우의 최댓값
        int[][][] dp = new int[N+1][12][10];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 12; j++) {
                for(int k = 0; k < 10; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 12; j++) {
                for(int k = 0; k < 10; k++) {
                    // 축구팀 뽑기
                    if (j > 0 && dp[i-1][j-1][k] != Integer.MIN_VALUE)
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k] + soccer[i]);
                    // 야구팀 뽑기
                    if (k > 0 && dp[i-1][j][k-1] != Integer.MIN_VALUE)
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1] + baseball[i]);
                    // 뽑지 않기
                    if (dp[i-1][j][k] != Integer.MIN_VALUE)
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                }
            }
        }
        System.out.println(dp[N][11][9]);
    }
}