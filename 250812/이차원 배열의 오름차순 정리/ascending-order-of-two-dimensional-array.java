import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long end = n * n;
        long start = 1L;
        long min = Long.MAX_VALUE;
        while(start <= end) {
            long cur = (start + end) / 2;
            long value = 0;
            for(int i = 1; i <= n; i++) {
                value += Math.min(n, cur/ i);
            }
            if (value >= k) {
                min = Math.min(min, cur);
                end = cur - 1;
            } else {
                start = cur + 1;
            }
        }

        System.out.println(min);
    }
}

// 1,1 ~ i,j
// a,b라면 
// 