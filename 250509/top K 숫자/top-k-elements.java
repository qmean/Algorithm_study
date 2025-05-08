import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        SortedSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int count = 1;
        for (Integer i : set) {
            if (count > k)
                break;
            System.out.print(i + " ");
            count++;
        }
    }
}