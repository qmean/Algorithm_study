import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] queries = new int[n];
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            set.add(i+1);
        }
        for (int i = 0; i < n; i++) {
            set.remove(sc.nextInt());
            System.out.println(set.last());
        }
        // Please write your code here.
    }
}