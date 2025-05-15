import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }
        // Please write your code here.
        for (int i = 0; i < M; i++) {
            Integer a = q.poll();
            q.add(a-1);
        }

        System.out.println(q.peek());
    }
}