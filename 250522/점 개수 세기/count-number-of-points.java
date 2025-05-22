import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer a = Integer.parseInt(st.nextToken());
            // System.out.println(a);
            set.add(a);
            // set.add(Integer.parseInt(st.nextToken()));
        }
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();
        int idx = 1;
        for (Integer i : set) {
            // System.out.println(i);
            map.put(i, idx);
            nums.add(i);
            idx++;
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Integer ceiling = nums.ceiling(a);
            Integer floor = nums.floor(b);
            if (ceiling == null || floor == null) {
                System.out.println(0);
                continue;
            }
            int min = map.get(ceiling);
            int max = map.get(floor);

            System.out.println(max - min + 1);
            // bw.write(String.valueOf(max - min + 1) + "\n");
            // if (i % 10 == 0) {
            //     bw.flush();
            // }
        }
        // bw.flush();
        // bw.close();
    }
}