import java.util.*;

public class Main {
    
    static HashSet<Integer>[] edges;
    static boolean[] visited;
    static int cnt = 0;
    static int root = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        edges = new HashSet[n];
        visited = new boolean[n];
        for (int i = 0 ; i < n; i++)
            edges[i] = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if (p == -1) {
                root = i;
                continue;
            }
            edges[p].add(i);
            edges[i].add(p);
        }

        int deleteNode = sc.nextInt();

        Integer[] deleteArr = new Integer[edges[deleteNode].size()];
        deleteArr = edges[deleteNode].toArray(deleteArr);
        for (Integer i : deleteArr) {
            edges[i].remove(deleteNode);
            edges[deleteNode].remove(i);
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(i + ":  ");
        //     for (Integer k : edges[i])
        //         System.out.print(k + " ");
        //     System.out.println();
        // }

        dfs(root);
        
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        visited[idx] = true;

        int childCnt = 0;
        for (Integer next : edges[idx]) {
            if (visited[next])
                continue;
            dfs(next);
            childCnt++;
        }

        if (childCnt == 0 && idx != root)
            cnt++;
    }
}