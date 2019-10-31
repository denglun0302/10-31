import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {
    public static class Node {
        private int value;
        private Node left = null;
        private Node right = null;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }

    private static int count;

    public int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
        return count;
    }

    public int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize(root.right);
        return left + right + 1;
    }

    public static int leafSize;

    public int getLeafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
        return leafSize;
    }

    public int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = leafSize(root.left);
        int right = leafSize(root.right);
        return left + right;
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public int getKLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        int left = getKLevel(root.left, k - 1);
        int right = getKLevel(root.right, k - 1);
        return left + right;

    }

    public Node find(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }
        Node n = find(root.left, val);
        if (n != null) {
            return n;
        }
        Node m = find(root.right, val);
        if (m != null) {
            return m;
        }
        return null;
    }

    public boolean find1(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.value == val) {
            return true;
        }
        if (find1(root.left, val)) {
            return true;
        }
        if (find1(root.right, val)) {
            return true;
        }
        return false;

    }

    public boolean isMirrorTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value
                && isMirrorTree(p.left, q.right)
                && isMirrorTree(p.right, q.left);
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }


    public boolean search(Node root, Node t) {
        if (root == null) {
            return true;
        }
        if (isSameTree(root, t)) {
            return true;
        }
        if (isSubTree(root.left, t)) {
            return true;
        }
        if (isSubTree(root.right, t)) {
            return true;
        }
        return false;

    }

    public boolean isSubTree(Node p, Node q) {
        return isSameTree(p, q);
    }

    public boolean search2(Node root, Node t) {
        if (root == null) {
            return false;
        }
        if (root == t) {
            return true;
        }
        if (search(root.left, t)) {
            return true;
        }
        if (search(root.right, t)) {
            return true;
        }
        return false;
    }


    public boolean isB(Node root) {
        if (root == null) {
            return true;
        }
        if (!(isB(root.left))) {
            return false;
        }
        if (!(isB(root.right))) {
            return false;
        }
        int a = getHeight(root.left);
        int b = getHeight(root.right);
        int diff = a - b;
        if (diff >= -1 && diff <= 1) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }

    public List<Integer> postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List left = postOrder(root.left);
        List right = postOrder(root.right);
        list.addAll(left);
        list.addAll(right);
        list.add(root.value);
        return list;
    }

    private List<Integer> list = new ArrayList<>();

    public void p(Node root) {
        if (root != null) {
            p(root.left);
            p(root.right);
            list.add(root.value);
        }
    }

    public List<Integer> post(Node root) {
        p(root);
        return list;
    }


    class Solution {
        private class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public TreeNode buildTree(int[] postorder, int[] inorder) {
            if (postorder.length == 0) {
                return null;
            }
            int rootValue = postorder[postorder.length - 1];
            int leftCount;
            for (leftCount = 0; leftCount < inorder.length; leftCount++) {
                if (inorder[leftCount] == rootValue) {
                    break;
                }
            }
            TreeNode root = new TreeNode(rootValue);
            int[] leftPostorder = Arrays.copyOfRange(postorder,
                    0, leftCount);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftCount);
            root.left = buildTree(leftPostorder, leftInorder);
            int[] rightPostorder = Arrays.copyOfRange(postorder,
                    leftCount, postorder.length - 1);
            int[] rightInorder = Arrays.copyOfRange(inorder,
                    leftCount + 1, inorder.length);
            root.right = buildTree(rightPostorder, rightInorder);

            return root;
        }



    }
}

