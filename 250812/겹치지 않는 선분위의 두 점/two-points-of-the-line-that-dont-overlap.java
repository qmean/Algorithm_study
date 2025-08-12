import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] start = new long[m];
        long[] end = new long[m];
        for (int i = 0; i < m; i++) {
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        long left = 0;
        long right = (long)10e18;
        long max = Long.MIN_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int i = 0;
            long cnt = 1L;
            long cur = start[0];
            while(i < m) {
                if (cur < start[i]) {
                    if (start[i] <= cur + mid && cur + mid <= end[i]) {
                        cur += mid;
                    } else if (cur + mid < start[i]) {
                        cur = start[i];
                    } else {
                        i++;
                        continue;
                    }
                    cnt++;
                }
                long nextCnt = (end[i] - cur) / mid;
                cur += nextCnt * mid;
                cnt += nextCnt;
                i++;
            }

            if (cnt >= n) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(max);
    }
}