import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();

        int end = 0;
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            while (end < arr.length && !set.contains(arr[end])) {
                set.add(arr[end]);
                end++;
            }

            max = Math.max(max, set.size());

            set.remove(arr[i]);
        }

        System.out.println(max);
    }
}