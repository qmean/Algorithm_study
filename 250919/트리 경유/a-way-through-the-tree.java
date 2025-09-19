import java.util.Scanner;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        visited = new boolean[n+1];
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int find = a;
            
            boolean valid = true;
            int lastNode = -1;
            while (find != 1) {
                if (visited[find]) {
                    valid = false;
                    lastNode = find;
                }
                find /= 2;
            }
            if (valid) {
                System.out.println(0);
                visited[a] = true;
            }
            else
                System.out.println(lastNode);
        }
    }
    
}