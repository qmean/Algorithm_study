import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        // List<Integer> neg = new ArrayList<>();
        // List<Integer> zero = new ArrayList<>();
        // List<Integer> pos = new ArrayList<>();
        
        // for(int i = 0; i < n; i++) {
        //     int v = arr[i]
        //     if (v > 0) {
        //         pos.add(v);
        //     } else if (v == 0) {
        //         zero.add(v);
        //     } else {
        //         pos.add(v);
        //     }
        // }
        // pos.sort(Comparator.naturalOrder());

        int i = 0;
        int j = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while(i < j) {
            int sum = arr[i] + arr[j];
            if (sum < 0) {
                i++;
            } else {
                j--;
            }
            min = Math.min(Math.abs(sum), min);
        }

        System.out.println(min);
    }
}