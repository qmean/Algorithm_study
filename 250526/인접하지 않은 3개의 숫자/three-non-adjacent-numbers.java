import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = arr[0];
        for(int i = 1; i < n; i++) {
            l[i] = Math.max(l[i-1], arr[i]);
        }
        r[0] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            r[i] = Math.max(r[i+1], arr[i]);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(l[i] + " ");
        }

        int max = Integer.MIN_VALUE;
        for(int i = 2; i < n-2; i++) {
            max = Math.max(arr[i] + l[i-2] + r[i+2], max);
        }

        System.out.println(max);
    }
}