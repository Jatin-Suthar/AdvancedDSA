package MinHeap_MaxHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num: nums) {
            q.add(num);
            if(q.size() > k) {
                q.poll();
            }
        }
        return (!q.isEmpty()) ? q.poll() : -1;
    }

}
