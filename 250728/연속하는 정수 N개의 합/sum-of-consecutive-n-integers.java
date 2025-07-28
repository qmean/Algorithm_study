import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int sum = 0;
        int j = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && sum < m) {
                sum += arr[j];
                j++;
            }
            if (sum == m) {
                cnt++;
            }
            sum -= arr[i];
        }

        System.out.println(cnt);
    }
}