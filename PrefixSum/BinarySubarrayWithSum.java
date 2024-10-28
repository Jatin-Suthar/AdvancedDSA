package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {
}

class BinarySubarrayWithSumSolution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int pSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for(int num: nums) {
            pSum += (num%2!=0) ? 1 : 0;
            if(map.containsKey(pSum-goal)) {
                ans += map.get(pSum-goal);
            }
            map.put(pSum, map.getOrDefault(pSum, 0)+1);
        }
        return ans;
    }
}