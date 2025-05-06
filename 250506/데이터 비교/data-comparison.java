import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        for(int i = 0; i < m; i++) {
            if (set1.contains(arr[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}