import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // Please write your code here.
        if (sum % 2 != 0) {
            System.out.println("No");
            return ;
        }
        boolean[] dp = new boolean[sum/2 + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            int cur = arr[i];
            for(int j = sum/2; j >= cur; j--) {
                if (dp[j - cur])
                    dp[j] = true;
            }
        }
        
        if (dp[sum/2])
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}