package MinHeap_MaxHeap;

import java.util.*;

public class MergeKSortedLinkedList {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(6);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode[] listNodeArray = new ListNode[2];
        listNodeArray[0] = listNode1;
        listNodeArray[1] = listNode2;
        Solution solution = new Solution();
        System.out.println(solution.mergeKLists(listNodeArray));
    }

}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListPair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.val));
        int n = lists.length;
        for(int i=0; i<n; i++) {
            ListNode curr = lists[i];
            if(curr!=null) {
                queue.add(new ListPair(curr.val, i, curr));
            }
        }
        ListNode res = new ListNode(0);
        ListNode newCurr = res;
        while(!queue.isEmpty()) {
            ListPair p = queue.poll();
            newCurr.next = new ListNode(p.val);
            newCurr = newCurr.next;
            int idx = p.idx;
            ListNode curr = p.curr;
            if(curr.next!=null) {
                queue.add(new ListPair(curr.next.val, idx, curr.next));
            }
        }
        return res.next;
    }

}

class ListPair {
    int val;
    int idx;
    ListNode curr;
    public ListPair(int val, int idx, ListNode curr) {
        this.val=val;
        this.idx=idx;
        this.curr=curr;
    }
}

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