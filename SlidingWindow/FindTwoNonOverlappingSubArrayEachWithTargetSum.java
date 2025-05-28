package SlidingWindow;

import java.util.*;

public class FindTwoNonOverlappingSubArrayEachWithTargetSum {
    public static void main(String[] args) {
        int[] arr = {2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 20;
        Solution solution = new Solution();
        System.out.println(solution.minSumOfLengths(arr, target));
    }
    static class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            int pSum = 0, sSum = 0, n = arr.length, ans = Integer.MAX_VALUE;
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            Map<Integer, Integer> pMap = new HashMap<>();
            Map<Integer, Integer> sMap = new HashMap<>();
            pMap.put(0, -1);
            sMap.put(0, n);
            prefix[0] = n;
            suffix[n-1] = n;
            pSum += arr[0];
            sSum += arr[n-1];
            for (int i = 1; i < n; i++) {
                int end = n-1-i;
                pSum += arr[i];
                sSum += arr[end];
                prefix[i] = prefix[i-1];
                suffix[end] = suffix[end+1];
                if (pMap.containsKey(pSum - target)) {
                    prefix[i] = Math.min(prefix[i], i - pMap.get(pSum - target));
                }
                if (sMap.containsKey(sSum - target)) {
                    suffix[end] = Math.min(suffix[end], sMap.get(sSum - target) - (end));
                }
                pMap.put(pSum, i);
                sMap.put(sSum, end);
            }
            for(int i=0; i<n-1; i++) {
                ans = Math.min(ans, prefix[i]+suffix[i+1]);
            }
            return ans;
        }
    }
/*
20
[2, 2, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
 2  4  8  12 16 20 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44
 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
map: {
    6  -> [{-1, 5}],
    5  -> [{1, 6}],
    8  -> [{2, 10}],
    11 -> [{3, 14}],
    14 -> [{4, 18}],
    17 -> [{5, 22}],
    20 -> [{6, 26}]
}
*/
}
