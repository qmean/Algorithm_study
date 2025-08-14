import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + a[i] < 0) {
                sum = 0;
                continue;
            } else {
                sum += a[i];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}