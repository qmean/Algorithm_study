import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        // Please write your code here.
    }
}