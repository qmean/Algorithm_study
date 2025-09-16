import java.util.*;

public class Main {

    static final int MAX_LEN = 1_000_000;
    static ArrayList<Integer>[] edge;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        edge = new ArrayList[MAX_LEN];
        cnt = new int[MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++)
            edge[i] = new ArrayList<>();
        int node = arr[0];
        int nodeIdx = 0;
        

        int before = arr[1];
        for (int i = 1; i < n; i++) {
            if (arr[i] - before > 1) {
                nodeIdx++;
                node = arr[nodeIdx];
            }
            edge[node].add(arr[i]);
            // edge[arr[i]].add(node);
            before = arr[i];
        }

        int root = arr[0];
        
        Set<Integer> set = new HashSet<>();
        set.add(root);
        while (!set.isEmpty()) {
            Set<Integer> tmp = set;
            set = new HashSet<>();

            int sum = 0;
            // tmp : 같은 depth 에 있는 node들
            for (int i : tmp) {
                sum += edge[i].size();
            }
            
            for (int i : tmp) {
                // 각 node에 대해 자식들의 리스트 cur
                for (int cur : edge[i]) {
                    set.add(cur);
                    cnt[cur] = sum - edge[i].size();
                }
            }
        }

        System.out.println(cnt[k]);
    }
}

// root에서 bfs 돌리기