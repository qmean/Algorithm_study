import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
            if (pq.size() < 3) {
                System.out.println(-1);
            } else {
                int i1 = pq.poll();
                int i2 = pq.poll();
                int i3 = pq.poll();
                System.out.println(i1 * i2 * i3);
                pq.add(i1);
                pq.add(i2);
                pq.add(i3);
            }
        }
        // Please write your code here.
    }
}