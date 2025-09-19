import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = (1 << k) - 1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        Queue<Segment> search = new LinkedList<>();
        search.add(new Segment(0, n-1));
        while (!search.isEmpty()) {
            Queue<Segment> s2 = search;
            search = new LinkedList<>();
            
            for (Segment s : s2) {
                System.out.print(a[s.mid] + " ");
                if (s.start == s.end)
                    continue;
                search.add(new Segment(s.start, s.mid - 1));
                search.add(new Segment(s.mid + 1, s.end));
            }
            System.out.println();
        }
        
    }
    
    static class Segment {
        int start;
        int end;
        int mid;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
            this.mid = (start + end) / 2;
        }
    }
}
// root -> right -> left