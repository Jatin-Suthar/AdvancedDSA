package LinkList;

public class ReverseNodeInKGroup {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        ListNode head = reverseKGroup(node, 2);
        node.print(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode lenCount = head;
        int len = 0;
        while(lenCount!=null) {
            len++;
            lenCount = lenCount.next;
        }
        int last = len-(len%k);
        int idx=0;
        ListNode start = head;
        ListNode prev = null;
        while(idx+k<=last) {
            ListNode[] info = reverse(head, start, k, prev);
            head = info[0];
            start = info[1];
            prev = info[2];
            idx+=k;
        }
        return head;
    }

    public static ListNode[] reverse(ListNode head, ListNode start, int upTo, ListNode prevIdx) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = start;
        int i=0;
        while(curr!=null && i!=upTo) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        start = prev;
        if(prevIdx!=null) {
            prevIdx.next = start;
        } else {
            head = start;
        }
        while(prev.next!=null) {
            prev=prev.next;
            prevIdx=prev;
        }
        prev.next=curr;
        return new ListNode[] {head, curr, prevIdx};
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void print(ListNode node) {
        ListNode curr = node;
        while(curr!=null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
