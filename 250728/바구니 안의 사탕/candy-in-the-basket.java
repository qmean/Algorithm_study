import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // int[] candyCount = new int[n];
        // int[] position = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int candyCount = sc.nextInt();
            int position = sc.nextInt();
            // candyCount[i] = sc.nextInt();
            // position[i] = sc.nextInt();
            map.put(position, map.getOrDefault(position, 0) + candyCount);
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = -k; i <= n; i++) {
            sum += map.getOrDefault(i + k, 0);
            sum -= map.getOrDefault(i - k - 1, 0);
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
    }
}