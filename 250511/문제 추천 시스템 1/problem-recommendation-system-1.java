import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Question> set = new TreeSet<>((q1, q2) -> {
            if (q1.l != q2.l) {
                return q2.l - q1.l;
            } else {
                return q2.p - q1.p;
            }
        });

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            set.add(Question.of(p,l));
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();

                if (x == 1) {
                    Question prt = set.first();
                    System.out.println(prt.p);
                } else {
                    Question prt = set.last();
                    System.out.println(prt.p);
                }
            } else if (command.equals("ad")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                set.add(Question.of(p,l));
            } else {
                int p = sc.nextInt();
                int l = sc.nextInt();
                set.remove(Question.of(p,l));
            }
        }
        // Please write your code here.
    }

    public static class Question {
        int p;
        int l;

        public static Question of(int p, int l) {
            Question q = new Question();
            q.p = p;
            q.l = l;
            return q;
        }

        @Override
        public boolean equals(Object o) {
            Question q = (Question)o;
            return q.p == this.p && q.l == this.l;
        }
    }
}