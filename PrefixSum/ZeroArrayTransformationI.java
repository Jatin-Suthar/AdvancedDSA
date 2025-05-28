package PrefixSum;

import java.util.*;

public class ZeroArrayTransformationI {
    public static void main(String[] args) {
        int[] nums = {3,4,3};
        int[][] queries = {{0,1},{1,2},{0,2},{0,2}};
        System.out.println(new Solution().isZeroArray(nums, queries));
    }
    static class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] diff = new int[n+1];
            for (int[] q : queries) {
                int l = q[0], r = q[1];
                diff[l] += 1;
                if (r + 1 < n) diff[r+1] -= 1;
            }

            int cover = 0;
            for (int i = 0; i < n; i++) {
                cover += diff[i];
                if (cover < nums[i])
                    return false;
            }

            return true;
        }
    }

/*

[1,0,1]
 1 1 2

[4,3,2,1]
[0,-1,-1,-1]
[-1,-2,-2,-1]
[-2,-3,-3,-1]
[-3,-4,-4,-1]
[-4,-5,-5,-1]
[[1,3],[0,2],[0,2],[0,2],[0,2]]

totalSum = 10 -> 7 ->

[4,7,9,10]
[4,6,7,7]
[3,4,]
*/
}
