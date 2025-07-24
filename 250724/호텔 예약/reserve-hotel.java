import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Reservation> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Reservation(s, 1));
            list.add(new Reservation(e, -1));
        }
        list.sort((r1, r2) -> {
            if (r1.date == r2.date) {
                return r2.v - r1.v;
            }
            return r1.date - r2.date;
        });
        int curDate = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(Reservation r : list) {
            max = Math.max(sum, max);
            sum += r.v;
        }
        max = Math.max(sum, max);
        System.out.println(max);
    }

    public static class Reservation {
        int date;
        int v;
        public Reservation(int date, int v) {
            this.date = date;
            this.v = v;
        }
    }
}