package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;
        for(int num: nums) {
            prefixSum += num;
            if(map.containsKey(prefixSum-k)) {
                count+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}