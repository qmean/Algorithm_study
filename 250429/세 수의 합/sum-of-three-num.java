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
        long ans = 0L;
        long ans2 = 0L;
        long ans3 = 0L;
        Set<Integer> set = map.keySet();
        for(Integer i1 : set) {
            for(Integer i2 : set) {
                int i3 = k - i1 - i2;

                if (i1 == i2 && i2 == i3) {
                    if (map.get(i1) < 3)
                        continue;
                    int v = map.get(i1);
                    ans += (v * (v-1) * (v-2))/6;
                }

                if (i1 == i2) {
                    if (map.get(i1) < 2)
                        continue;
                    int v = map.get(i1);
                    ans2 += ((v * (v-1))/2) * map.getOrDefault(i3, 0);
                } else if (i1 == i3) {
                    if (map.get(i1) < 2)
                        continue;
                    int v = map.get(i1);
                    ans2 += ((v * (v-1))/2) * map.getOrDefault(i2, 0);
                } else if (i2 == i3) {
                    if (map.get(i2) < 2)
                        continue;
                    int v = map.get(i2);
                    ans2 += ((v * (v-1))/2) * map.getOrDefault(i1, 0);
                }

                if (i1 != i2 && i2 != i3) {
                    ans3 += map.get(i1) * map.get(i2) * map.getOrDefault(i3, 0);
                }
            }
        }

        long print = ans + (ans2 / 3) + (ans3 / 6);

        System.out.println(print);
    }
}