import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[n];
        int[] reverseDp = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(reverseDp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(int i = n-1; i >= 0; i--) {
            // System.out.println("======" + i + "======");
            for(int j = i+1; j < n; j++) {
                // System.out.println(i + " " + j);
                if (arr[i] > arr[j]) {
                    reverseDp[i] = Math.max(reverseDp[i], reverseDp[j] + 1);
                }
            }
            // System.out.println(reverseDp[i]);
            // System.out.println("------------------");
        }

        int max = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++) {
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < n; i++) {
        //     System.out.print(reverseDp[i] + " ");
        // }
        // System.out.println();
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i] + reverseDp[i] - 1);
        }

        System.out.println(max);
    }
}
/*
최장 증가, 감소 수열 구하는 dp 만들고 합치기?

1 2 3 4 5 6 5 4 3 2 1 이라 하면
증가는 정방향 1 2 4 5 6
감소는 역방향 6 3 2 1 -> 역방향 최장 증가 수열

n이 1000 이므로 n^2 까지는 문제없음
*/