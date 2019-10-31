import java.util.Stack;

public class Tree {
    public static class Node {
        private int value;
        private Node left = null;
        private Node right = null;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public void preorder(Node root) {

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.print(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    public void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(cur.value);
            cur = top.right;
        }
    }

    public void postorder(Node root) {

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if (top.right == null || top.right == last) {
                System.out.print(top.value);
                stack.pop();
                last = top;
            } else {
                cur = top.right;
            }
        }
    }
}



