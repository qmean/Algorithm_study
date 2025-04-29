import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k,v);
            } else if (cmd.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            } else {
                int k = sc.nextInt();
                int find = map.getOrDefault(k, 0);
                if (find > 0) {
                    System.out.println(find);
                } else {
                    System.out.println("None");
                }
            }
        }
    }
}