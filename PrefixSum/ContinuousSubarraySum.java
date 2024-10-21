package PrefixSum;

import java.util.*;

public class ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7}; int k = 6;
        ContinuousSubarraySumSolution solution = new ContinuousSubarraySumSolution();
        System.out.println(solution.checkSubarraySum(nums,k));
    }

}

class ContinuousSubarraySumSolution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        map.put(nums[0]%k, 0);
        for(int i=1; i<n; i++) {
            pSum[i] = pSum[i-1] + nums[i];
            int key = pSum[i]%k;
            if(key==0) return true;
            if(map.containsKey(key)) {
                if(Math.abs(pSum[i]-pSum[map.get(key)])%k==0 && i-map.get(key)>1) return true;
            } else {
                map.put(key, i);
            }
        }
        return false;
    }
}