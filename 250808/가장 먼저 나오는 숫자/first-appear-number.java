import java.util.Scanner;
public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            System.out.println(lower(queries[i]) + 1);
        }
    }

    static int lower(int f) {
        int lower = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == f) {
                lower = Math.min(lower, mid);
                right = mid - 1;
            } else if (arr[mid] > f) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (lower == Integer.MAX_VALUE) {
            return -2;
        } else {
            return lower;
        }
    }
}