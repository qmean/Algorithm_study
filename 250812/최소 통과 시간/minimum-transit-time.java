import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        int MAX_TIME = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            MAX_TIME = Math.max(MAX_TIME, arr[i]);
        }

        long start = 0L;
        long end = MAX_TIME * n;
        long min = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;
            long value = 0L;
            for(int i = 0; i < m; i++) {
                value += mid / arr[i];
            }

            if (value >= n) {
                end = mid - 1;
                min = Math.min(mid, min);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);
    }
}