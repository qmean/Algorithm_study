import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                q.add(sc.nextInt());
            } else if (cmd.equals("pop")) {
                int a = q.poll();
                System.out.println(a);
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(q.peek());
            }
        }
    }
}