package BinarySearch;

import java.util.*;

public class MinimizeTheMaximumDistanceBetweenPairs {
    static class Solution {
        public int minimizeMax(int[] nums, int p) {
            if(p==0) return 0;
            Arrays.sort(nums);
            int n = nums.length;
            int st = 0, ed = nums[n-1] - nums[0];
            while(st < ed) {
                int mid = (st+ed) >> 1;
                if(canMake(nums, p, mid)) {
                    ed = mid;
                } else {
                    st = mid+1;
                }
            }
            return st;
        }
        public boolean canMake(int[] nums, int p, int d) {
            int n = nums.length, used = 0;
            for(int i=1; i<n && used < p; ) {
                if(nums[i]-nums[i-1] <= d) {
                    used++;
                    i+=2;
                } else {
                    i+=1;
                }
            }
            return used >= p;
        }
    }

/*

1 1 2 3 7 10



*/
}
