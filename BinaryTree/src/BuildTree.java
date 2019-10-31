import java.util.*;

public class BuildTree {
    private static class Node{
        private char val;
        private  Node left;
        private  Node  right;
        private Node(char val){
            this.val=val;
        }
    }
    private static class RV{
        private Node root;
        private int used;

        private RV(Node root,int used){
            this.root=root;
            this.used=used;
        }
    }

    private static RV buildTree(char[] preorder){
        if(preorder.length==0){
            return new RV(null,0);
        }
        if(preorder[0]=='#'){
            return new RV (null,1);
        }
        RV leftreturn=buildTree(Arrays.copyOfRange(preorder,0,preorder.length));
        RV rightreturn=buildTree(Arrays.copyOfRange(preorder,leftreturn.used+1,preorder.length));
        Node root= new Node( preorder[0]);
        root.left=leftreturn.root;
        root.right=rightreturn.root;
        return new RV(root,1+leftreturn.used+rightreturn.used);

    }

    private static void inorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.val);
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] charArray = line.toCharArray();
        RV rv = buildTree(charArray);
        inorderTraversal(rv.root);
    }

}

