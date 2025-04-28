import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] a = new int[N+1][M];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int[][] dp = new int[N+1][M];
        for(int i = 0; i < M; i++) {
            dp[1][i] = a[1][i];
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < M; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + a[i][j]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < M; i++) {
            max = Math.max(max, dp[N][i]);
        }

        System.out.println(max);
    }
}