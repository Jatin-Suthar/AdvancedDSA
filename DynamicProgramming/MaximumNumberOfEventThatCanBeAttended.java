package DynamicProgramming;

import java.util.*;

public class MaximumNumberOfEventThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1,2,4},{3,4,3},{2,3,10}};
        int k = 2;
        System.out.println(new Solution().maxValue(events, k));
    }
    static class Solution {
        Map<String, Integer> map = new HashMap<>();
        public int maxValue(int[][] events, int k) {
            Arrays.sort(events,
                    Comparator.comparing((int[] a) -> a[0])
                            .thenComparing((int[] a) -> a[1])
            );
            return recur(events, k, 0, 0);
        }
        public int recur(int[][] events, int k, int idx, int end) {
            if(k==0) return 0;
            if(idx==events.length) return 0;
            String key = k + "," + idx + "," + end;
            if(map.get(key)!=null) return map.get(key);
            int max = 0;
            int nextEventIdx = searchNext(events, idx, events.length-1, end);
            if(nextEventIdx!=-1) {
                max = events[nextEventIdx][2] + recur(events, k-1, idx+1, events[nextEventIdx][1]);
            }
            max = Math.max(max, recur(events, k, idx+1, end));
            map.put(key, max);
            return max;
        }

        private int searchNext(int[][] events, int st, int ed, int end) {
            int ans = -1;
            while(st<=ed) {
                int mid = (st+ed) >> 1;
                if(end < events[mid][0]) {
                    ans = mid;
                    ed = mid-1;
                } else {
                    st = mid+1;
                }
            }
            return ans;
        }
    }
}
