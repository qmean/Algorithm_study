import java.util.Scanner;
public class Main {

    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        final int TEAM_A = n;
        final int TEAM_B = n+1;
        uf = new int[n+2];
        for (int i = 0; i <= n+1; i++) {
            uf[i] = i;
        }
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            int ar = find(a);
            int br = find(b);
            if (ar == a && br == b) {
                union(a, TEAM_A);
                union(b, TEAM_B);
            } else if (ar == br) {
                flag = false;
                break;
            } else if (ar == a && br != b) {
                int newTeam = br == TEAM_A ? TEAM_B : TEAM_A;
                union(a, newTeam);
            } else if (br == b && ar != a) {
                int newTeam = ar == TEAM_A ? TEAM_B : TEAM_A;
                union(b, newTeam);
            }
        }

        System.out.println(flag ? 1 : 0);
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        uf[f] = find(uf[f]);
        return uf[f];
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br)
            return false;

        if (ar > br)
            uf[br] = ar;
        else
            uf[ar] = br;
        return true;
    }
}