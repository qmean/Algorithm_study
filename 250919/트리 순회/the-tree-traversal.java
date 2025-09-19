import java.util.*;

public class Main {

    static HashMap<Character, Segment> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            map.put(root, new Segment(left, right));
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
        System.out.println();
    }

    static void preOrder(char node) {
        if (node == '.')
            return;

        System.out.print(node);
        preOrder(map.get(node).left);
        preOrder(map.get(node).right);
    }

    static void inOrder(char node) {
        if (node == '.')
            return;

        
        inOrder(map.get(node).left);
        System.out.print(node);
        inOrder(map.get(node).right);
    }

    static void postOrder(char node) {
        if (node == '.')
            return;

        postOrder(map.get(node).left);
        postOrder(map.get(node).right);
        System.out.print(node);
    }

    static class Segment {
        char left;
        char right;

        public Segment(char l, char r) {
            this.left = l;
            this.right = r;
        }
    }
}