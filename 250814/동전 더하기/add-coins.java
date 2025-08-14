import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int cnt = 0;
        int sum = 0;
        int idx = n-1;
        while(idx >= 0) {
            int a = (k - sum) / coins[idx];
            sum += coins[idx] * a;
            cnt += a;
            idx--;
        }
        System.out.println(cnt);
    }
}