import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            long v = k - arr[i];
            if (map.get(v) == null) {
                map.put((long)arr[i], 0L);
            } else {
                map.put(v, map.get(v) + 1);
            }
        }
        // Please write your code here.
        long sum = 0L;
        sum = map.entrySet().stream().mapToLong(e -> e.getValue()).sum();
        System.out.println(sum);
    }
}