import java.util.*;
public class Main {

    static ArrayList<Integer>[] edges;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        
        edges = new ArrayList[10000];
        indegree = new int[10000];

        for (int i = 0; i < 10000; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            indegree[b]++;
        }

        int root = -1;
        int rootCnt = 0;
        for (int i = 0; i < 10000; i++) {
            if (indegree[i] >= 2) {
                System.out.println(0);
                return;
            }
            if (indegree[i] == 0 && edges[i].size() != 0) {
                root = i;
                rootCnt++;
            }
        }

        if (root == -1) {
            System.out.println(0);
            return;
        } else if (rootCnt != 1) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }
}