import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map1.put(words[i], i);
            map2.put(i, words[i]);
        }
        // Please write your code here.
        for(int i = 0; i < m; i++) {
            String cmd = sc.next();
            int num;
            try {
                num = Integer.parseInt(cmd);
            } catch (Exception e) {
                num = 0;
            }
            if (num == 0) {
                System.out.println(map1.get(cmd));
            } else {
                System.out.println(map2.get(num));
            }
        }
    }
}