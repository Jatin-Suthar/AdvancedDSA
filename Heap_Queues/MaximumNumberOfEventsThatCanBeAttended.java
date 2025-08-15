package Heap_Queues;

import java.util.*;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1,2},{2,2},{1,2},{1,2}};
        System.out.println(new Solution().maxEvents(events));
    }
    static class Solution {
        public int maxEvents(int[][] events) {
            int n = events.length;
            Arrays.sort(events,
                    (Comparator.comparingInt((int[] p) -> p[0]).thenComparingInt((int[] p) -> p[1])));
            int count = 0, i = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    Comparator.comparingInt((int[] e) -> e[1])
            );
            for (int day = 1; day <= 100000; day++) {
                while (i < n && events[i][0] == day) {
                    pq.add(events[i++]);
                }
                if(!pq.isEmpty()) {
                    pq.poll();
                    count++;
                }
                while (!pq.isEmpty() && pq.peek()[1] == day) pq.poll();
            }
            return count;
        }
    }
/*
 1 2 3 4 5
| | | | | |
|-|
  |-|
  |---|

#each day max 2 events can get's completed
*/
}
