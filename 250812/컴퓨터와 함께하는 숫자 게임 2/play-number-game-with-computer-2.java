import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        int depth = 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(long i = a; i <= b; i++) {
            int find = bs(i, m);
            min = Math.min(min, find);
            max = Math.max(max, find);
        }

        System.out.format("%d %d\n", min, max);
    }

    public static int bs(long find, long m) {
        long start = 1L;
        long end = m;
        long mid = (start + end) / 2;
        int depth = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            depth++;
            if (mid == find) {
                break;
            } else if (mid < find) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return depth;
    }
}