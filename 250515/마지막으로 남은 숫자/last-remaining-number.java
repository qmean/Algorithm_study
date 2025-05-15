import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        // Please write your code here.
        while (q.size() >= 2) {
            int a1 = q.poll();
            int a2 = q.poll();
            if (a1 != a2)
                q.add(a1-a2);
        }

        if (q.isEmpty())
            System.out.println(-1);
        else
            System.out.println(q.poll());
    }
}