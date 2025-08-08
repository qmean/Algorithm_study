import java.util.Scanner;
public class Main {
    static int[] arr;
    static int f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            f = sc.nextInt();
            System.out.println(find(0, n-1) + 1);
        }
    }

    private static int find(int start, int end) {
        int cur = (start + end) / 2;
        while(arr[cur] != f && start != cur && end != cur) {
            // System.out.format("s : %d e : %d cur : %d\n", start, end, cur);
            if (arr[cur] < f) {
                start = cur;
            } else {
                end = cur;
            }
            cur = (start + end) / 2;
        }
        int ret = -2;
        if (arr[cur] == f) {
            return cur;
        } else if (arr[start] == f){
            return start;
        } else if (arr[end] == f) {
            
            return end;
        }
        return ret;
    }
}