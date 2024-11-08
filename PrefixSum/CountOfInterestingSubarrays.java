package PrefixSum;

import java.util.*;

public class CountOfInterestingSubarrays {
}

class CountOfInterestingSubarraysSolution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long curSum = 0, ans = 0;
        for(int num: nums) {
            curSum = (curSum + (num%mod == k ? 1 : 0))%mod;
            ans += map.getOrDefault((curSum - k + mod)%mod, 0);
            map.put(curSum, map.getOrDefault(curSum, 0)+1);
        }
        return ans;
    }
}

/*

(nums[i]%mod == k) ? 1 : 0

[3,1,9,6]
[1,0,2,3]

pSumI = (pSumJ - k + m)%m


*/