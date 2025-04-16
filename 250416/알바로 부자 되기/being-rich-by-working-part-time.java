import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[1001];

        Arrays.fill(dp, Integer.MIN_VALUE);
        for(int i = 0; i < n; i++) {
            int iStart = s[i];
            int iPay = p[i];
            dp[iStart] = p[i];
            for(int j = 0; j < i; j++) {
                int jEnd = e[j];
                int jStart = s[j];
                if (jEnd < iStart) {
                    dp[iStart] = Math.max(dp[iStart], dp[jStart] + iPay);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= 1000; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}