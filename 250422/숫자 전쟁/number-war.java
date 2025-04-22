import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n+3][n+3];
        for(int i = 0; i <= n+2; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        dp[1][1] = 0;
        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                // 현재 카드 내는게 가능한 경우
                if (dp[i][j] < 0)
                    continue;
                // 승부를 보는 경우
                if (a[j] > b[i]) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + b[i]);
                } else if (a[j] < b[i]) {
                    dp[i][j+1] = Math.max(dp[i][j+1],dp[i][j]);
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
                }

                // 버리는 경우
                dp[i+1][j+1] = dp[i][j];
            }
        }
        for(int i = 0; i <= n+2; i++) {
            for(int j = 0; j <= n+2; j++) {
                // System.out.print(dp[i][j] + " ");
                max = Math.max(max, dp[i][j]);
            }
            // System.out.println();
        }
        System.out.println(max);
    }
}

/*
1. 대결
    카드가 다름
        수가 작은 사람이 '카드에 적힌 수'만큼 점수를 얻음
        작은 수가 적힌 카드를 버림
    카드가 같음
        점수를 얻지 못함
        둘 다 카드를 버림
2. 카드 버리기
    둘 다 카드를 버림

둘 중 하나의 더미가 소진될 때까지 게임을 함

구하는 값 -> 두번째 플레이어가 받을 수 있는 최대 점수
*/