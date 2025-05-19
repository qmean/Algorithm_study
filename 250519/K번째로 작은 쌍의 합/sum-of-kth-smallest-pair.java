import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] nArr = new int[n];
        int[] mArr = new int[m];

        for(int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int np = 0;
        while (true) {
            if (np >= n)
                break;
            int curN = nArr[np];
            if (pq.size() == k && pq.peek() < curN + mArr[0]) {
                break;
            }
            for(int i = 0; i < m; i++) {
                pq.add(curN + mArr[i]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            np++;
        }

        // pq.forEach(i -> System.out.println(i));

        System.out.println(pq.peek());
    }
}