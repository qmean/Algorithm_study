import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] ndegree;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nodeNames = new String[n];
        edges = new ArrayList[n];
        Map<String, Integer> map = new HashMap<>();
        ndegree = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            nodeNames[i] = sc.next();
            map.put(nodeNames[i], i);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String x = sc.next();
            String y = sc.next();
            int xIdx = map.get(x);
            int yIdx = map.get(y);
            edges[yIdx].add(xIdx);
            ndegree[xIdx]++;
        }
        
        Queue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<String> pq2 = new PriorityQueue<>(Comparator.naturalOrder());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (ndegree[i] == 0) {
                pq2.add(nodeNames[i] + " ");
                pq.add(i);
            }   
        }

        System.out.println(pq.size());
        pq2.forEach(s -> System.out.print(s));
        System.out.println();
        List<Segment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Segment(nodeNames[i]));
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            
            for (int next : edges[cur]) {
                if (--ndegree[next] == 0){
                    pq.add(next);
                    list.get(cur).names.add(nodeNames[next]);
                }
            }
        }
        list.sort((sg1, sg2) -> sg1.s.compareTo(sg2.s));
        list.forEach(sg -> System.out.println(sg));
    }

    static class Segment {
        String s;
        Queue<String> names;

        public Segment(String s) {
            this.s = s;
            this.names = new PriorityQueue<>();
        }
        
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(s + " ");
            sb.append(names.size() + " ");
            while (!names.isEmpty()) {
                sb.append(names.poll() + " ");
            }
            return sb.toString();
        }
    }
}