import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Please write your code here.
        long sum = 0L;
        long sum2 = 0L;
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> e : set) {
            if (e.getKey() * 2 == k) {
                sum2 += (e.getValue() * (e.getValue() - 1)) / 2 ;
                continue ;
            }
            sum += e.getValue() * map.getOrDefault(k - e.getKey(), 0);
        }
        long ans = sum2 + (sum / 2);
        System.out.println(ans);
    }
}