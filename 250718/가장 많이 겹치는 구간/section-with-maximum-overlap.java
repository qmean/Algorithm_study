import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[200001]; 
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arr[x1]++;
            arr[x2]--;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0; 
        for(int i = 0; i <= 200000; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}