import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }
        // Please write your code here.
        // dp[a][b][c] = a 번째 원소에서 b를 골랐을때 인접한 숫자가 다른 횟수 c인 수열의 유사도 최댓값
        int[][][] dp = new int[N][4][M+1];
        // 모든 배열 초기화
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k <= M; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        // dp[0] 초기화
        for(int i = 0; i < 4; i++) {
            if (seq[0] == i) {
                dp[0][i][0] = 1;
            }
            else
                dp[0][i][0] = 1;
        }

        for(int i = 1; i < N; i++) {
            int curSeq = seq[i];
            for(int j = 0; j < 4; j++) {
                boolean eq = (j+1) == curSeq;
                int score = eq ? 1 : 0;
                // 인접한 숫자가 다른 횟수 k
                for(int k = 0; k <= M; k++) {
                    // i-1에서 선택한 값 b
                    for(int b = 0; b < 4; b++) {
                        // 이전과 현재가 같을 경우
                        if (j == b && dp[i-1][b][k] >= 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][b][k] + score);
                            continue ;
                        }
                        // 이전과 현재가 다를 경우
                        if (k > 0 && dp[i-1][b][k-1] >= 0)
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][b][k-1] + score);
                    }
                }
            }
        }

        int max = -1;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j <= M; j++) {
                max = Math.max(dp[N-1][i][j], max);
            }
        }

        System.out.println(max);
    }
}