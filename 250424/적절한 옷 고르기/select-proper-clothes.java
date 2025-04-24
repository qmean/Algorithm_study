import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // Please write your code here.
        // dp[a][b] = 날짜 a에 옷 b를 입는 경우 만족도 합의 최댓값
        int[][] dp = new int[m+1][n];

        for(int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        // 첫째날 초기화
        for(int i = 0; i < n; i++) {
            // 1번째 날에 옷을 입을 수 없는 경우 넘김
            if (s[i] > 1)
                continue;
            // 옷을 입을 수 있는 경우 0으로 초기화
            dp[1][i] = 0;
        }

        for(int d = 2; d <= m; d++) {
            // i = 날짜 d에 입을 옷의 인덱스
            for(int i = 0; i < n; i++) {
                // 날짜 d에 옷 i를 입을 수 없는 경우 검사
                if (s[i] > d || e[i] < d)
                    continue;
                // j = 전날에 입은 옷의 인덱스
                for(int j = 0; j < n; j++) {
                    if (dp[d-1][j] < 0)
                        continue;
                    dp[d][i] = Math.max(dp[d][i], dp[d-1][j] + Math.abs(v[j] - v[i]));
                }
            }
        }

        // for(int i =0; i <= m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[m][i]);
        }
        
        System.out.println(max);
    }
}