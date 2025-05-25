import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] lArr = new int[n];
        int[] rArr = new int[n];
        lArr[0] = 0;
        rArr[n-1] = 0;
        for(int i = 1; i < n; i++) {
            lArr[i] = lArr[i-1] + Math.abs(x[i-1] - x[i]) + Math.abs(y[i-1] - y[i]);
            rArr[n-i-1] = rArr[n-i] + Math.abs(x[n-i-1] - x[n-i]) + Math.abs(y[n-i-1] - y[n-i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++) {
            min = Math.min(min, lArr[i-1] + rArr[i+1] + Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]));
        }
        
        System.out.println(min);
    }
}