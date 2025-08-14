import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }
        Arrays.sort(pos);

        long start = 0;
        long end = (long)10e9;
        long min = Long.MAX_VALUE;
        while(start <= end) {
            long mid = (start + end) / 2;
            long curRight = pos[0] + 2 * mid;
            long cnt = 1L;
            for(int i = 1; i < n; i++) {
                if (curRight < pos[i]) {
                    curRight = pos[i] + 2 * mid;
                    cnt++;
                }
            }
            if (cnt > k) {
                start = mid + 1;
            } else {
                min = Math.min(min, mid);
                end = mid - 1;
            }
        }
        System.out.println(min);
    }
}