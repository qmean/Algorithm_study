import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            max = Math.max(map.get(arr[i]), max);
        }
        // Please write your code here.
        System.out.println(max);
    }
}