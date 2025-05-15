import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            int mid = arr[0];
            System.out.print(mid + " ");
            Queue<Integer> q1 = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> q2 = new PriorityQueue<>();
            for(int i = 1; i < m; i++) {
                if (arr[i] < mid) {
                    q1.add(arr[i]);
                } else {
                    q2.add(arr[i]);
                }
                // 짝수번째
                if (i%2 != 1) {
                    if (q1.size() > q2.size()) {
                        int nMid = q1.poll();
                        q2.add(mid);
                        mid = nMid;
                    } else if (q1.size() < q2.size()) {
                        int nMid = q2.poll();
                        q1.add(mid);
                        mid = nMid;
                    }
                    System.out.print(mid + " ");
                }
            }

            System.out.println();
        }
    }
}