import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        
        int j = 0;
        int cnt = 0;
        for (int i = 0 ; i < m; i++) {
            while(j < n && A[j] != B[i]) {
                j++;
            }
            if (j < n && A[j] == B[i])
                cnt++;
        }

        String ans = cnt == B.length ? "Yes" : "No";
        System.out.println(ans);
    }
}