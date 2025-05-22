import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        TreeSet<Integer> nums = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (Integer i : nums) {
            map.put(i, idx);
            idx++;
        }
        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Integer ceiling = nums.ceiling(a);
            Integer floor = nums.floor(b);
            if (ceiling == null || floor == null) {
                System.out.println(0);
                continue;
            }
            int min = map.get(ceiling);
            int max = map.get(floor);

            System.out.println(max - min + 1);
        }
    }
}