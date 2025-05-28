package Heap_Queues;

import java.util.*;

public class ZeroTransformationIII {
    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2},{1,1},{0,2}};
        Solution solution = new Solution();
        System.out.println(solution.maxRemoval(nums, queries));
    }
    static class Solution {
        public int maxRemoval(int[] nums, int[][] queries) {
            int n = nums.length, m = queries.length;
            Arrays.sort(queries, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
            int applied = 0, q = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i=0; i<n; i++) {
                while(q<m && queries[q][0] == i) {
                    maxHeap.add(queries[q][1]);
                    q++;
                }
                int t = nums[i];
                while(!maxHeap.isEmpty() && minHeap.size()<t && maxHeap.peek() >= i) {
                    applied++;
                    minHeap.add(maxHeap.poll());
                }
                if(minHeap.size() < nums[i]) return -1;
                while(!minHeap.isEmpty() && minHeap.peek() == i) {
                    minHeap.poll();
                }
            }
            return m-applied;
        }
    }


/*
diff array:
[2,1,-1]
[2,3,2]

[2,0,2]
[[0,2],[0,2],[1,1]]

[2,0,0]
[2,2,2]

[2,2,4]
*/
}
