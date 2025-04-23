import java.util.Scanner;
public class Main {

    public static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
        }
        // Please write your code here.
        dp = new long[N+1][41];
        // 0 - 19 = 음수
        // 20 = 0
        // 21 - 40 = 양수

        // 초기값 갱신
        dp[0][20] = 1;
        for(int i = 1; i <= N; i++) {
            int cur = numbers[i];
            for(int j = 0; j <= 40; j++) {
                int k = j - 20;

                // 이전 선택에서 값이 없는 경우
                if (dp[i-1][j] == 0)
                    continue;
                
                // 더하는 경우
                if(j + cur <= 40)
                    dp[i][j + cur] += dp[i-1][j];
                // 빼는 경우
                if (j - cur >= 0)
                    dp[i][j - cur] += dp[i-1][j];
            }
        }

        // for(int i = 0; i < dp.length; i++) {
        //     for(int j = 0; j < dp[i].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[N][M+20]);
    }
}