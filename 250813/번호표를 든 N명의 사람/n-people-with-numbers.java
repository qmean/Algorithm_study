import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tMax = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        int left = 0;
        int right = n;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < Math.min(mid, n); i++) {
                pq.add((long)d[i]);
            }
            int next = Math.min(mid, n);
            long time = 0;
            while(!pq.isEmpty()) {
                time = pq.poll();
                if (next < n)
                    pq.add(d[next] + time);
                next++;
            }
            if (time <= tMax) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(min);
    }
}