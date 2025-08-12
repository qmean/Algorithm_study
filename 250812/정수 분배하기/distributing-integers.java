import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int start = 1;
        int end = max;
        // 정수 k
        int mid = 1;
        int ans = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int cnt = 0;
            for(int i : arr) {
                cnt += i / mid;
            }
            if (cnt >= m) {
                start = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.format("%d\n", ans);
    }
}