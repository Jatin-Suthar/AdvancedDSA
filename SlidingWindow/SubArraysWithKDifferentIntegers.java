package SlidingWindow;

import java.util.*;

public class SubArraysWithKDifferentIntegers {
}

class SubArraysWithKDifferentIntegersSolution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarraysWithAtMostKDistinct(nums, k) - countSubarraysWithAtMostKDistinct(nums, k - 1);
    }
    private int countSubarraysWithAtMostKDistinct(int[] nums, int k) {
        if (k <= 0) return 0;
        int start = 0, count = 0, n = nums.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int end = 0; end < n; end++) {
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);
            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
                if (frequencyMap.get(nums[start]) == 0) {
                    frequencyMap.remove(nums[start]);
                }
                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }
}
