import java.util.*;
    public class LevelOrder {
        public static class Node {
            private int value;
            private Node left = null;
            private Node right = null;

            public Node(Node left, Node right) {
                this.left = left;
                this.right = right;
            }
        }
        public static class  NodeLevel{
            public Node  node;
            public int level;

            public NodeLevel(Node node,int level) {
                this.node = node;
                this.level = level;
            }
        }

        public void buildTree(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node front = queue.poll();
                System.out.print(front.value);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }


            }
        }
    public static void levelOrder2(Node root) {
      if(root==null){
          return;
      }
      Queue<NodeLevel> queue=new LinkedList<>();
      queue.offer(new NodeLevel(root,1));
      while(!queue.isEmpty()){
          NodeLevel front=queue.poll();
          System.out.println(front.level + ":" + front.node.value);
          if(front.node.left!=null){
              queue.offer(new NodeLevel(front.node.left,front.level));
          }
          if(front.node.right!=null){
              queue.offer(new NodeLevel(front.node.right,front.level));
          }
      }
    }

     public boolean isCompleteTree(Node root) {
         if (root == null) {
             return true;
         }
         Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         while (true) {
             Node front=queue.poll();

             if (front==null) {
                 break;
             }
             queue.offer(front.left);
             queue.offer(front.right);
         }
         while(!queue.isEmpty()){
             if(queue.poll()!=null){
                 return false;
             }

         }
         return true;
     }

     }



