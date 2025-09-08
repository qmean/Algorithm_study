import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] k = new int[m];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++)
            set.add(i+1);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            Integer find = set.floor(a);
            if (find == null) {
                break;
            } else {
                set.remove(find);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

// 넣을 수 있는 칸 중 가장 index가 큰 빈칸에 넣는 것이 최적