import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        long sum = 0L;
        int min = Integer.MAX_VALUE;
        int j = 1;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i + " " + j + " " + sum);
            while(j <= n && sum  < s) {
                sum += arr[j];
                j++;
            }
            if (sum >= s)
                min = Math.min(min, j - i);
            sum -= arr[i];
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}