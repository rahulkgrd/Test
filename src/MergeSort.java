import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        Node head=new Node(12,new Node(11,new Node(13,new Node(5,new Node(6,new Node(7))))));
        Node sorted=mergeSortLL(head);
        while (sorted!=null){
            System.out.println(sorted.data);
            sorted=sorted.next;
        }
    }

    static void sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        mergeLL(arr, l, mid, r);
// 1 2 3 4 5
    }

    static void mergeLL(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node mergeLL(Node node1, Node node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        Node result = null;
        if (node1.data <= node2.data) {
            result = node1;
            result.next = mergeLL(node1.next, node2);
        } else {
            result = node2;
            result.next = mergeLL(node1, node2.next);
        }
        return result;
    }
    static Node getMid(Node node) {
        if (node == null | node.next == null)
            return node;
        Node slow = node, fast = node;
        while (fast != null && fast.next != null&& fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeSortLL(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = getMid(head);
        Node midNext = mid.next;
        mid.next = null;
        Node left = mergeSortLL(head);
        Node right = mergeSortLL(midNext);

        return mergeLL(left, right);
    }
}
