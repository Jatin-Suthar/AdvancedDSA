package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {
    public static void main(String[] args) {
        int k = -5;
        System.out.println((k%2 + 6)%6);
    }
}

class SubArraySumDivisibleByKSolution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pSum = 0, ans = 0;
        for (int num : nums) {
            pSum = (((pSum + num) % k) + k) % k;
            if (map.containsKey(pSum)) {
                ans += map.get(pSum);
            }
            map.put(pSum, map.getOrDefault(pSum, 0) + 1);
        }
        return ans;
    }
}
/*

pSumJ - pSumI = q*k
pSumJ%k - pSumI%k = 0
pSumJ%k = pSumI%k
as we have some negative values also:

((pSum+nums[i]%k)+k)%k we will keep this value

*/