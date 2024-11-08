package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        int p = 6;
        MakeSumDivisibleByPSolution solution = new MakeSumDivisibleByPSolution();
        System.out.println(solution.minSubarray(nums, p));
    }

}

class MakeSumDivisibleByPSolution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int modSum = 0, minLen = nums.length, n = nums.length;
        for(int i=0; i<n; i++) {
            modSum = (modSum+nums[i])%p;
            if(map.containsKey(modSum)) {
                minLen = Math.min(minLen, n-(i-map.get(modSum)));
            }
            map.put(modSum, i);
        }
        return minLen;
    }
}