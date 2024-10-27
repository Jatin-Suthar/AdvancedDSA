package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable {

    int[] range;
    public RangeSumQueryImmutable(int[] nums) {
        range = new int[nums.length+1];
        int pSum = 0;
        range[0] = 0;
        for(int i=0; i<nums.length; i++) {
            pSum += nums[i];
            range[i+1] = pSum;
        }
    }

    public int sumRange(int left, int right) {
        return range[right+1]-range[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */