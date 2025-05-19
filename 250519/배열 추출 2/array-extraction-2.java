import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            if (Math.abs(i1) != Math.abs(i2)) {
                return Math.abs(i1) - Math.abs(i2);
            } else {
                return i1 - i2;
            }
        });
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            // Please write your code here.
            if (x != 0) {
                pq.add(x);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}