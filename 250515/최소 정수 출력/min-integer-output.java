import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            // Please write your code here.
            if (x > 0) {
                q.add(x);
            } else {
                if (q.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(q.poll());
            }
        }
    }
}