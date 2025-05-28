package SlidingWindow;

import java.util.*;

public class LongestContinuousSubArrayWithAbsoluteDifferenceLessThanOrEqualToK {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(nums, limit));
    }
    static class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length, st = 0, max = 0;
            if(limit == 0) return n;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int ed=0; ed<n; ed++) {
                map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
                while(map.lastKey() - map.firstKey() > limit) {
                    int freq = map.get(nums[st]);
                    map.put(nums[st], --freq);
                    if(freq == 0) {
                        map.remove(nums[st]);
                    }
                    st++;
                }
                max = Math.max(max, ed-st+1);
            }
            return max;
        }
    }

/*

2

abcd

ab
ac
ad
bc
bd
cd

a-b <= k

|a-b| <= k
|b-c| <= k
|a-c| <= k

|a-b| + |b-c| + |a-c| <= (totalPair)*k;

*/
}
