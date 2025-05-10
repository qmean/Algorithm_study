import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int find = arr[i];
            int ceiling = find + m;
            int floor = find - m;
            
            Integer down = set.floor(floor);
            Integer up = set.ceiling(ceiling);

            if (down != null) {
                min = Math.min(min, find - down);
            }
            if (up != null) {
                min = Math.min(min, up - find);
            }
        }

        System.out.println(min);
    }
}