import java.util.*;

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
        Object[] mapArr = map.entrySet().toArray();
        Arrays.sort(mapArr, (o1, o2) -> {
            Map.Entry<Integer, Integer> e1 = (Map.Entry<Integer, Integer>)o1;
            Map.Entry<Integer, Integer> e2 = (Map.Entry<Integer, Integer>)o2;
            if (e1.getValue() == e2.getValue()) {
                return e2.getKey() - e1.getKey();
            } else {
                return e2.getValue() - e1.getValue();
            }
        });

        for(int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>)mapArr[i];
            System.out.print(e.getKey() + " ");
        }
    }
}