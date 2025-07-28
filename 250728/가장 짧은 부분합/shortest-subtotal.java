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
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i + " " + j + " " + sum);
            while(j + 1 <= n && sum + arr[j + 1] < s) {
                sum += arr[j + 1];
                j++;
            }
            min = Math.min(min, j - i + 2);
            sum -= arr[i];
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
}