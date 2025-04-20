import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int c;

        c = a >= b ? 1 : 0;
        System.out.println(c);
        c = a > b ? 1 : 0;
        System.out.println(c);
        c = b >= a ? 1 : 0;
        System.out.println(c);
        c = b > a ? 1 : 0;
        System.out.println(c);
        c = a == b ? 1 : 0;
        System.out.println(c);
        c = a != b ? 1 : 0;
        System.out.println(c);
    }
}