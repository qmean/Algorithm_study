import java.util.*;

public class Main {
    static int[] points;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            int l = lower(a);
            int u = upper(b);
            if (l == Integer.MAX_VALUE || u == Integer.MIN_VALUE || l > u) {
                System.out.println(0);
                continue;
            }
            System.out.println(u - l + 1);

        }
    }

    static int lower(int k) {
        int l = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (points[mid] < k) {
                left = mid + 1;
            } else if (points[mid] > k) {
                right = mid - 1;
                l = Math.min(l, mid);
            } else {
                l = mid;
                break;
            }
        }
        return l;
    }

    static int upper(int k) {
        int u = Integer.MIN_VALUE;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (points[mid] < k) {
                left = mid + 1;
                u = Math.max(u, mid);
            } else if (points[mid] > k) {
                right = mid - 1;
            } else {
                u = mid;
                break;
            }
        }
        return u;
    }
}