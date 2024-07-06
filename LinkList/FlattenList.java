package LinkList;

public class FlattenList {

    public static void main(String[] args) {
        Node list = new Node(5);
        list.bottom = new Node(7);
        list.bottom.bottom = new Node(8);
        list.bottom.bottom.bottom = new Node(30);
        list.next = new Node(10);
        list.next.bottom = new Node(20);
        list.next.next=new Node(19);
        list.next.next.bottom=new Node(22);
        list.next.next.bottom.bottom=new Node(50);
        list.next.next.next=new Node(28);
        list.next.next.next.bottom=new Node(35);
        list.next.next.next.bottom.bottom=new Node(40);
        list.next.next.next.bottom.bottom.bottom=new Node(45);
        Node ans = flatten1(list);
        list.print(ans);
    }

    public static Node flatten(Node root) {
        Node curr = root;
        Node next = curr.next;
        while(next!=null) {
            Node l1 = curr;
            Node l2 = next;
            Node prev = null;
            while(l1!=null && l2!=null) {
                if(l1.data<l2.data) {
                    prev=l1;
                    l1=l1.bottom;
                } else {
                    Node ad = new Node(l2.data);
                    l2 = l2.bottom;
                    if(l1==curr) {
                        ad.bottom = l1;
                        curr = ad;
                    } else {
                        prev.bottom = ad;
                        ad.bottom=l1;
                    }
                    prev=ad;
                }
            }
            if(l2!=null) {
                prev.bottom = l2;
            }
            curr.next=next.next;
            next=next.next;
        }
        return curr;
    }

    static Node flatten1(Node root) {
        Node head = new Node(0);
        Node right = root.next;//it will only go right
        while(right!=null) {
            Node curr = head;
            Node l1 = root;
            Node l2 = right;
            System.out.println("l1: " + l1.data + " | l2: " + l2.data);
            while(l1!=null && l2!=null) {
                if(l1.data<l2.data) {
                    curr.bottom = new Node(l1.data);
                    curr = curr.bottom;
                    l1 = l1.bottom;
                } else {
                    curr.bottom = new Node(l2.data);
                    curr = curr.bottom;
                    l2 = l2.bottom;
                }
            }
            while(l1!=null) {
                curr.bottom = new Node(l1.data);
                curr = curr.bottom;
                l1 = l1.bottom;
            }
            while(l2!=null) {
                curr.bottom = new Node(l2.data);
                curr = curr.bottom;
                l2 = l2.bottom;
            }
            root = head.bottom;
            right = right.next;
        }
        return root;
    }

    static void printList(Node root) {
        Node curr = root;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
        System.out.println();
    }

}

class Node {
    int data;
    Node next;
    Node bottom;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }

    public void print(Node root) {
        Node temp = root;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.bottom;
        }
    }
}
