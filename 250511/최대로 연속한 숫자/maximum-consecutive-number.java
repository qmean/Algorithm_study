import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Length> pset = new TreeSet<>((l1, l2) -> {
            return l1.start - l2.start;
        });
        TreeSet<Length> lset = new TreeSet<>((l1, l2) -> {
            if (l1.l != l2.l) {
                return l1.l - l2.l;
            } else if (l1.start != l2.start) {
                return l1.start - l2.start;
            } else {
                return l1.end - l2.end;
            }
        });
        Length l = Length.of(0,n);
        pset.add(l);
        lset.add(l);
        for (int i = 0; i < m; i++) {
            int remove = sc.nextInt();
            Length find = pset.floor(Length.of(remove, remove));
            if (find.start == remove && find.end == remove) {
                pset.remove(find);
                lset.remove(find);
            } else if (find.start == remove) {
                pset.remove(find);
                lset.remove(find);
                Length newL = Length.of(find.start + 1, find.end);
                pset.add(newL);
                lset.add(newL);
            } else if (find.end == remove) {
                pset.remove(find);
                lset.remove(find);
                Length newL = Length.of(find.start, find.end - 1);
                pset.add(newL);
                lset.add(newL);
            } else {
                pset.remove(find);
                lset.remove(find);
                Length l1 = Length.of(find.start, remove -1);
                Length l2 = Length.of(remove + 1, find.end);
                pset.add(l1);
                lset.add(l1);
                pset.add(l2);
                lset.add(l2);
            }
            System.out.println(lset.last().l);
        }
        // Please write your code here.
    }

    public static class Length {
        int l;
        int start;
        int end;

        public static Length of(int start, int end) {
            Length l = new Length();
            l.start = start;
            l.end = end;
            l.l = end - start + 1;
            return l;
        }
    }
}