package Interview;

import java.util.Map;
import java.util.stream.Collectors;

public class LoopyLinkedList {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        Node third = root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        Node last = root.next.next.next.next.next = new Node(6);
        last.next = third;
        System.out.println("Loop present: " + detectLoopInLinkedList(root));
    }
    private static boolean detectLoopInLinkedList(Node root) {
        Node slow = root;
        Node fast = root;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                return true;
            }
        }
        return false;
    }

}

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}