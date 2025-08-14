import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        long sum = 0L;
        while(pq.size() > 1) {
            int i1 = pq.poll();
            int i2 = pq.poll();
            sum += i1 + i2;
            pq.add(i1 + i2);
        }
        System.out.println(sum);
    }
}