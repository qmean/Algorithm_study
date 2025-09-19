import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < q; i++) {
            int find = sc.nextInt();
            int a = find;
            int print = 0;

            while (find != 1) {
                if (visited.contains(find)) {
                    print = find;
                }
                find /= 2;
            }
            bw.write(String.valueOf(print) + "\n");
            if (print == 0) {
                visited.add(a);
            }
            bw.flush();
        }
    }
    
}