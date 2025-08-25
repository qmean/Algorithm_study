import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) x[i] = sc.nextInt();
        for (int i = 0; i < n; i++) v[i] = sc.nextInt();
        // Please write your code here.
        int left = 1;
        int right = 1000000000;
        double min = Double.MAX_VALUE;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int maxIdx = 0;
            double max = Integer.MIN_VALUE;
            // System.out.format("left : %d right : %d mid %d\n", left, right, mid);
            for(int i = 0; i < n; i++) {
                double time = (double)Math.abs(x[i] - mid) / (double)v[i];
                if (time > max) {
                    maxIdx = i;
                    max = time;
                }
            }
            if (max < min) {
                min = max;
            }
            if (x[maxIdx] < mid) {
                right = mid - 1;
            } else if (x[maxIdx] > mid) {
                left = mid + 1;
            } else {
                break;
            }
        }
        System.out.format("%.4f\n", min);
    }
}