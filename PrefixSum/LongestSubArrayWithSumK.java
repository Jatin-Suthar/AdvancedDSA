package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
}

class LongestSubArrayWithSumKSolution {
    // Function for finding maximum and value pair
    public int lenOfLongSubArr(int[] A, int N, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pSum = 0, maxLen = 0;
        for(int i=0; i<N; i++) {
            pSum += A[i];
            if(map.containsKey(pSum-K)) {
                maxLen = Math.max(maxLen, i-map.get(pSum-K));
            }
            map.putIfAbsent(pSum, i);
        }
        return maxLen;
    }
}