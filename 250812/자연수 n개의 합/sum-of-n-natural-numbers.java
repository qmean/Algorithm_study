import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long end = (long)Math.sqrt(2 * s);
        long start = 1L;
        long mid = 0;
        long max = Integer.MIN_VALUE;
        while (start <= end) {
            mid = (start + end) / 2;
            long value = (mid * (mid + 1)) / 2;
            if (value <= s) {
                start = mid + 1;
                max = Math.max(max, mid);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(max);
    }
}