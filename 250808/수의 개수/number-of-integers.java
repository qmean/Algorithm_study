import java.util.Scanner;
public class Main {
    static int[] arr;
    static int x;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            int l = lower();
            if (l == -1) {
                System.out.println(0);
                continue;
            }
            int u = upper();
            // System.out.println("===" + l + " " + u + "===");
            System.out.println(u - l + 1);
        }
    }

    private static int lower() {
        int lower = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == x) {
                lower = Math.min(lower, mid);
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (lower == Integer.MAX_VALUE)
            return -1;
        else
            return lower;
    }

    private static int upper() {
        int upper = Integer.MIN_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == x) {
                upper = Math.max(upper, mid);
                left = upper + 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (upper == Integer.MAX_VALUE)
            return -1;
        else
            return upper;
    }
}