import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n];
        for (int i = 0; i < n; i++) {
            matches[i] = sc.next().charAt(0);
        }
        // Please write your code here.

        // 가위 바위 보자기 * 좌 우
        int[][][] dp = new int[3][2][n];
        
        // l 채우기
        dp[0][0][0] = 0;
        dp[1][0][0] = 0;
        dp[2][0][0] = 0;
        if (matches[0] == 'H') {
            dp[0][0][0] = 1;
        } else if (matches[0] == 'S') {
            dp[1][0][0] = 1;
        } else {
            dp[2][0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[j][0][i] = dp[j][0][i-1];
            }
            if (matches[i] == 'H') {
                dp[0][0][i] = dp[0][0][i-1] + 1;
            } else if (matches[i] == 'S') {
                dp[1][0][i] = dp[1][0][i-1] + 1;
            } else {
                dp[2][0][i] = dp[2][0][i-1] + 1;
            }
        }

        // r 채우기
        dp[0][1][n-1] = 0;
        dp[1][1][n-1] = 0;
        dp[2][1][n-1] = 0;
        if (matches[n-1] == 'H') {
            dp[0][1][n-1] = 1;
        } else if (matches[n-1] == 'S') {
            dp[1][1][n-1] = 1;
        } else {
            dp[2][1][n-1] = 1;
        }        
        for (int i = n-2; i >= 0; i--) {
            for(int j = 0; j < 3; j++) {
                dp[j][1][i] = dp[j][1][i+1];
            }
            if (matches[i] == 'H') {
                dp[0][1][i] = dp[0][1][i+1] + 1;
            } else if (matches[i] == 'S') {
                dp[1][1][i] = dp[1][1][i+1] + 1;
            } else {
                dp[2][1][i] = dp[2][1][i+1] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            int tmp1 = Math.max(dp[0][0][i], dp[1][0][i]);
            tmp1 = Math.max(dp[2][0][i], tmp1);

            int tmp2 = Math.max(dp[0][1][i+1], dp[1][1][i+1]);
            tmp2 = Math.max(dp[2][1][i+1], tmp2);
            max = Math.max(max, tmp1 + tmp2);
        }
        max = Math.max(dp[0][0][n-1], max);
        max = Math.max(dp[1][0][n-1], max);
        max = Math.max(dp[2][0][n-1], max);
        max = Math.max(dp[0][1][0], max);
        max = Math.max(dp[1][1][0], max);
        max = Math.max(dp[2][1][0], max);
        System.out.println(max);
    }
}