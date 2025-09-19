import java.util.*;

public class Main {

    static char[] tree;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        tree = new char[(int)Math.pow(2,n) + 1];
        Arrays.fill(tree, '.');

        tree[1] = 'A';
        map.put('A', 1);

        for (int i = 0; i < n; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            int rootIdx = map.get(root);
            int leftIdx = rootIdx * 2;
            int rightIdx = rootIdx * 2 + 1;
            
            tree[leftIdx] = left;
            tree[rightIdx] = right;
            map.put(left, leftIdx);
            map.put(right, rightIdx);
        }

        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
        System.out.println();
    }

    static void preOrder(int node) {
        if (tree[node] == '.')
            return;

        System.out.print(tree[node]);
        preOrder(node * 2);
        preOrder(node * 2 + 1);
    }

    static void inOrder(int node) {
        if (tree[node] == '.')
            return;

        inOrder(node * 2);
        System.out.print(tree[node]);
        inOrder(node * 2 + 1);
    }

    static void postOrder(int node) {
        if (tree[node] == '.')
            return;

        postOrder(node * 2);
        postOrder(node * 2 + 1);
        System.out.print(tree[node]);
    }
}