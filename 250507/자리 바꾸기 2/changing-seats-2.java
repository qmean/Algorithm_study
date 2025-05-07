import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        Set<Integer>[] setArr = new Set[n+1];
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            setArr[i] = new HashSet<>();
            arr[i] = i;
            setArr[i].add(i);
        }
        for(int i = 0; i < 3; i++) {
            // a[j]와 b[j]번째 사람들이 자리를 바꾼다
            for(int j = 0; j < k; j++) {
                setArr[arr[a[j]]].add(b[j]);
                setArr[arr[b[j]]].add(a[j]);
                int tmp = arr[a[j]];
                arr[a[j]] = arr[b[j]];
                arr[b[j]] = tmp;
            }
        }

        for(int i = 1; i <= n; i++) {
            int s = setArr[i].size();
            System.out.println(s);
        }
    }
}