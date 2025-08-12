import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long end = 3 * n;
        long start = 1L;
        long mid = start;
        while(start <= end) {
            mid = (start + end) / 2;
            long value = mid - mid/3 - mid/5 + mid/15;
            if (value == n) {
                break;
            } else if (value > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(mid);
    }
}

// 16 -> 3배수 5개, 5 배수 3개, 15배수 1개