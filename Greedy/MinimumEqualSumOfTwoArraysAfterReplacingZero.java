package Greedy;

public class MinimumEqualSumOfTwoArraysAfterReplacingZero {
    static class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            long sum1 = 0, sum2 = 0;
            int zero1 = 0, zero2 = 0;
            for(int num: nums1) {
                sum1 += ((num == 0) ? 1 : num);
                if(num == 0) zero1++;
            }
            for(int num: nums2) {
                sum2 += ((num == 0) ? 1 : num);
                if(num == 0) zero2++;
            }
            if(sum1 > sum2) {
                return findMinEqual(sum1, sum2, zero2);
            }
            return findMinEqual(sum2, sum1, zero1);
        }
        public long findMinEqual(long sum1, long sum2, int zero) {
            if(zero == 0) {
                if(sum1 == sum2) return sum1;
                else return -1;
            }
            return sum1;
        }
    }
/*
3,2,1,1,1 : 8
6,5,1     : 12

2,1,2,1 : 6
1,7     : 8

2,1,2,1  : 6
1,5,1    : 7
*/
}
