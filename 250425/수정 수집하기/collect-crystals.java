import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();
        // Please write your code here.
        final int L = 0;
        final int R = 1;

        // 1. 시점 2. 이전에 선택한 방향 (왼쪽, 오른쪽) 3. 자리를 옮긴 횟수
        int[][][] dp = new int[N+1][2][K+1];

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k <= K; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][0] = 0;

        for(int i = 1; i <= N; i++) {
            char cur = s.charAt(i-1);
            for(int d = 0; d < 2; d++) {
                int curScore = 0;
                if (d == L && cur == 'L') {
                    curScore = 1;
                } else if (d == R && cur == 'R') {
                    curScore = 1;
                }
                int opposite = d == L ? R : L;
                for(int k = 0; k <= K; k++) {
                    if (k > 0 && dp[i-1][opposite][k-1] >= 0)
                        dp[i][d][k] = Math.max(dp[i-1][opposite][k-1] + curScore, dp[i][d][k]);
                    if (dp[i-1][d][k] >= 0)
                        dp[i][d][k] = Math.max(dp[i-1][d][k] + curScore, dp[i][d][k]);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j <= K; j++) {
                max = Math.max(dp[N][i][j], max);
            }
        }

        System.out.println(max);
    }
}