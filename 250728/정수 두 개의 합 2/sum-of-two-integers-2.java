import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        int cnt = 0;
        int j = 0;
        
        for(int i = 0; i < n; i++) {
            // System.out.println("loop : " + i + " " + j);
            while(j < n && arr[i] + arr[j] <= k) {
                // System.out.println(i + " " + j);
                j++;
            }
            if (j > i && arr[i] + arr[j-1] <= k) {
                cnt += j -1 - i;
            }
        }

        System.out.println(cnt);
    }
}