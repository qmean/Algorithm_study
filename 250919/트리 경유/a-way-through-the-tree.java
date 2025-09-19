import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int find = a;
            
            boolean valid = true;
            int lastNode = -1;
            while (find != 1) {
                if (visited.contains(find)) {
                    lastNode = find;
                    valid = false;
                }
                find /= 2;
            }
            if (valid) {
                System.out.println(0);
                visited.add(a);
            }
            else
                System.out.println(lastNode);
        }
    }
    
}