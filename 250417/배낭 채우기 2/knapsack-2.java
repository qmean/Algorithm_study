import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[m+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                int curv = value[j];
                int curw = weight[j];
                if (i - curw >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - curw] + curv);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= m; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}