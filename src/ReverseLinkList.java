public class ReverseLinkList {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6,null))))));
        Node reverse=reverse(head);
        while (reverse!=null){
            System.out.println(reverse.data);
            reverse=reverse.next;
        }
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node pre = null, current = head, next = null;
        while (current!=null ){
           next=current.next;
           current.next=pre;
           pre=current;
           current=next;
        }
        return pre;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
