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
        int j = n-1;
        
        for(int i = 0; i < n; i++) {
            while(j >= 0 && j > i && arr[i] + arr[j] > k) {
                j--;
            }
            if (j <= i) {
                break;
            }
            cnt += j - i;
        }

        System.out.println(cnt);
    }
}