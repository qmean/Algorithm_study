import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int j = 0;
        // int cnt = arr[j] == 1 ? 1 : 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && cnt < k) {
                cnt += arr[j] == 1 ? 1 : 0;
                j++;
            }
            // System.out.println(i + " " + j);
            if (cnt >= k)
                min = Math.min(j - i, min);
            cnt -= arr[i] == 1 ? 1 : 0;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(min);
    }
}