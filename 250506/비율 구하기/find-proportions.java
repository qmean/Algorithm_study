import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        SortedMap<String, Integer> map = new TreeMap<>();
        long cnt = 0L;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            cnt++;
        }
        // Please write your code here.
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for(Map.Entry<String, Integer> e : set) {
            int cur = e.getValue();
            System.out.format("%s %.4f\n", e.getKey(), (double)((cur * 100)/cnt));
        }
    }
}