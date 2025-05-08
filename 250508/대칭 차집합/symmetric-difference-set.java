import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        // Please write your code here.
        int cnt = 0;
        for(Integer i : a) {
            if (b.contains(i)) {
                cnt++;
            }
        }

        System.out.println(a.size() + b.size() - (2 * cnt));
    }
}