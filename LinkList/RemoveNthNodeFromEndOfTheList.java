package LinkList;

public class RemoveNthNodeFromEndOfTheList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int k = 0;
        while(k!=n) {
            fast = fast.next;
            k++;
        }

        if(fast==null) return head.next;

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode del = slow.next;
        slow.next = slow.next.next;
        del = null;
        return head;
    }

}
