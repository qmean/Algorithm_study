import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        SortedSet<Pair> set = new TreeSet<>((p1, p2) -> {
           if (p1.value == p2.value) {
                return p1.num - p2.num;
           } else
                return p2.value - p1.value;
        });
        int maxnum = Integer.MIN_VALUE;
        int j = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while(j < n && maxnum <= k) {
                Pair p = new Pair(arr[j], map.getOrDefault(arr[j], 0));
                if (set.contains(p))
                    set.remove(p);
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                p.value += 1;
                set.add(p);
                maxnum = set.first().value;
                j++;
            }
            if (maxnum > k) {
                max = Math.max(max, j - i - 1);
            }

            Pair p = new Pair(arr[i], map.get(arr[i]));
            if (set.contains(p))
                set.remove(p);
            map.put(arr[i], map.get(arr[i]) - 1);
            p.value -= 1;
            set.add(p);
            maxnum = set.first().value;
        }
        System.out.println(max);
    }

    public static class Pair {
        int num;
        int value;

        public Pair(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}