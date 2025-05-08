import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            SortedSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();
                // Please write your code here.
                if (command == 'I') {
                    set.add(num);
                } else {
                    if (set.isEmpty())
                        continue;
                    if (num == 1) {
                        set.remove(set.last());
                    } else {
                        set.remove(set.first());
                    }
                }
            }
            if (set.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(set.last() + " " + set.first());
            }
        }
    }
}