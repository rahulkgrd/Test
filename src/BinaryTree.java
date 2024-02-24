import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    //        1
    //     2    3
    // 4   5  6   7
    public static void main(String[] args) {
        Node binaryTree = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        printLevelOrder(binaryTree);
    }
    static class Node {
        Node left;
        int data;
        Node right;

        public Node(int data, Node left, Node right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static void printLevelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp != null) {
                System.out.print(tmp.data + " ");
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            } else {
                System.out.println();
                if (!q.isEmpty())
                    q.add(null);
            }

        }
    }
}
