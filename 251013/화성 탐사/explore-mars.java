import java.util.*;

public class Main {

    static Map<Integer, Base> base = new HashMap<>();
    static List<Edge>[] edges;
    static int[][] map;
    static int[][] idMap;
    static int id = 0;
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] uf;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        idMap = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(idMap[i], -1);
        List<Integer> startId = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    startId.add(id);
                }
                if (map[i][j] == 1 || map[i][j] == 2) {
                    base.put(id, new Base(i,j));
                    idMap[i][j] = id;
                    id++;
                }
            }
        }
        edges = new ArrayList[id];
        uf = new int[id];
        for (int i = 0; i < id; i++) {
            edges[i] = findEdges(i);
            uf[i] = i;
        }
        int sId = startId.get(0);
        PriorityQueue<Edge> pq = new PriorityQueue<>((s1, s2) -> s1.v - s2.v);
        for (int id : startId) {
            union(sId, id);
            pq.addAll(edges[id]);
        }
        // System.out.println(pq);
        int sum = 0;
        int cnt = 1;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(sId, cur.to)) {
                // System.out.println(cur);
                sum += cur.v;
                pq.addAll(edges[cur.to]);
                cnt++;
            }
        }

        if (cnt == id) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }

    static int find(int f) {
        if (uf[f] == f)
            return f;
        return uf[f] = find(uf[f]);
    }

    static boolean union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br)
            return false;
        uf[ar] = br;
        return true;
    }

    static List<Edge> findEdges(int targetId) {
        List<Edge> list = new ArrayList<>();
        int[][] visited = new int[n][n];
        for (int j = 0; j < n; j++)
            Arrays.fill(visited[j], -1);
        visited[base.get(targetId).x][base.get(targetId).y] = 0;
        Queue<Segment> q = new LinkedList<>();
        q.add(new Segment(base.get(targetId).x, base.get(targetId).y));
        while (!q.isEmpty()) {
            Segment cur = q.poll();
            int curx = cur.x;
            int cury = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (map[nx][ny] == -1)
                    continue;
                if (visited[nx][ny] >= 0)
                    continue;

                visited[nx][ny] = visited[curx][cury] + 1;
                if (idMap[nx][ny] != -1) {
                    list.add(new Edge(idMap[nx][ny], visited[nx][ny]));
                }
                q.add(new Segment(nx, ny));
            }
        }
        return list;
    }

    static class Segment {
        int x;
        int y;
        
        public Segment(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("[x = %d, y = %d]", x, y);
        }
    }

    static class Edge {
        int to;
        int v;

        public Edge(int to, int v) {
            this.to = to;
            this.v = v;
        }

        @Override
        public String toString() {
            return String.format("[to = %d, v = %d]", to, v);
        }
    }

    static class Base {
        int x;
        int y;

        public Base(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Base b = (Base)o;
            return b.x == this.x && b.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("[x: %d y: %d]", x, y);
        }
    }
}