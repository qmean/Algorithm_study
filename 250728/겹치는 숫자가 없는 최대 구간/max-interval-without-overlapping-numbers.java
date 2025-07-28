import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int j = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            while(j < n && set.size() == j - i) {
                set.add(arr[j]);
                j++;
            }
            max = Math.max(max, j-i);
            set.remove(arr[i]);
        }

        System.out.println(max);
    }
}