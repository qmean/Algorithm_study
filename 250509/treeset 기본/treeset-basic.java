import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        // Please write your code here.
        for(int j = 0; j < n; j++) {
            String command = sc.next();
            if (command.equals("add")) {
                int i = sc.nextInt();
                set.add(i);
            } else if (command.equals("remove")) {
                int i = sc.nextInt();
                set.remove(i);
            } else if (command.equals("find")) {
                int i = sc.nextInt();
                if (set.contains(i)) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            } else if (command.equals("lower_bound")) {
                int i = sc.nextInt();
                if (set.ceiling(i) != null) {
                    System.out.println(set.ceiling(i));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("upper_bound")) {
                int i = sc.nextInt();
                if (set.higher(i) != null) {
                    System.out.println(set.higher(i));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("largest")) {
                if (set.isEmpty()) {
                    System.out.println("None");
                } else {
                    System.out.println(set.last());
                }
            } else {
                if (set.isEmpty()) {
                    System.out.println("None");
                } else {
                    System.out.println(set.first());
                }
            }
        }
    }
}