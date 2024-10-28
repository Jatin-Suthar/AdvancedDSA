package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubstring {
}

class CountNumberOfNiceSubstringSolution {
    public int numberOfSubarrays(int[] nums, int k) {
        int pSum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num: nums) {
            pSum += (num%2!=0) ? 1 : 0;
            if(map.containsKey(pSum-k)) {
                ans += map.get(pSum-k);
            }
            map.put(pSum, map.getOrDefault(pSum, 0)+1);
        }
        return ans;
    }
}