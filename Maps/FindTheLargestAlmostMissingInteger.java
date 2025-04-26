package Maps;

import java.util.ArrayList;
import java.util.TreeMap;

public class FindTheLargestAlmostMissingInteger {
}

class Solution {
    public int largestInteger(int[] nums, int k) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        int n;
        for(int i=0; i<(n = nums.length); i++) {
            int num = nums[i];
            map.computeIfAbsent(num, x -> new int[2]);
            int[] pair = map.get(num);
            pair[0]++;
            pair[1] = i;
            map.put(num, pair);
        }
        int ans = -1;
        for(int key: map.keySet()) {
            int[] pair = map.get(key);
            if(pair[0]==1) {
                if(k==1 || k==n) {
                    ans = Math.max(ans, key);
                } else if(pair[1] == 0 || pair[1] == n-1) {
                    ans = Math.max(ans, key);
                }
            }
        }
        return ans;
    }
}