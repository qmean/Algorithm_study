import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, (i1, i2) -> {
            String s1 = i1.toString();
            String s2 = i2.toString();
            int idx = 0;
            while(idx < s1.length() && idx < s2.length()) {
                if (s1.charAt(idx) != s2.charAt(idx))
                    return s2.charAt(idx) - s1.charAt(idx);
                idx++;
            }
            long a1 = Long.parseLong(s1 + s2);
            long a2 = Long.parseLong(s2 + s1);
            if (a1 > a2) {
                return -1;
            } else {
                return 1;
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}