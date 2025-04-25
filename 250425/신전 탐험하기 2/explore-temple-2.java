import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        // Please write your code here.

        // n 번째 선택, 해당 선택에 몇번 째 방에 들어갔는지, 1층에서 들어갔던 방은 뭔지
        int[][][] dp = new int[n+1][3][3];

        dp[1][0][0] = arr[1][0];
        dp[1][1][1] = arr[1][1];
        dp[1][2][2] = arr[1][2];

        for(int i = 2; i <= n; i++) {
            for(int cur = 0; cur < 3; cur++) {
                for(int before = 0; before < 3; before++) {
                    if (cur == before) continue;
                    for(int start = 0; start < 3; start++) {
                        dp[i][cur][start] = Math.max(dp[i][cur][start], dp[i-1][before][start] + arr[i][cur]);
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (i == j) continue;
                max = Math.max(dp[n][i][j], max);
            }
        }

        System.out.println(max);
    }
}