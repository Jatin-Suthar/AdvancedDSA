package MergeSort;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {

        ListNode curr = this;
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        while(curr!=null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        sb.append("]");

        return sb.toString();
    }
}

public class MergeKSortedArrays {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(7);
        listNode1.next.next.next = new ListNode(8);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(9);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(3);
        listNode3.next.next = new ListNode(4);

        ListNode[] listNodeArray = new ListNode[3];
        listNodeArray[0] = listNode1;
        listNodeArray[1] = listNode2;
        listNodeArray[2] = listNode3;
        Solution solution = new Solution();
        System.out.println(solution.mergeKLists(listNodeArray));
    }
    
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return divideAndMerge(lists, 0, lists.length-1);
    }

    private ListNode divideAndMerge(ListNode[] lists, int start, int end) {
        if(start<end) {
            int mid = (start+end)/2;
            ListNode l1 = divideAndMerge(lists, start, mid);
            ListNode l2 = divideAndMerge(lists, mid+1, end);
            return merge(l1, l2);
        }
        return lists[start];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if(l1!=null) {
            curr.next = l1;
        }
        if(l2!=null) {
            curr.next = l2;
        }
        return head.next;
    }
}