package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
}

class CountNumberOfBadPairsSolution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long goodPair = 0;
        for(int i=0; i<n; i++) {
            int key = i-nums[i];
            if(map.containsKey(key)) {
                goodPair += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        long totalPairs = (n*(n-1))/2;
        return totalPairs-goodPair;
    }
}

// j-i!=nums[j]-nums[i]

// j-nums[j]!=i-nums[i]