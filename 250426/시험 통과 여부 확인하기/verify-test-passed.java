import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i >= 80) {
            System.out.println("pass");
        } else {
            System.out.println(80-i + " more score");
        }
    }
}