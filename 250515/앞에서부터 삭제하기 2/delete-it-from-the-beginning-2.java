import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sum += arr[n-1];
        sum += arr[n-2];
        q.add(arr[n-1]);
        q.add(arr[n-2]);
        double ans = Double.MIN_VALUE;
        ans = Math.max(arr[n-1], arr[n-2]);
        int size = 2;
        for(int i = 3; i <= n; i++) {
            q.add(arr[n-i]);
            sum += arr[n-i];
            size++;

            ans = Math.max(ans, (sum - q.peek()) / (size - 1));
        }

        System.out.format("%.2f\n", ans);
    }
}