package Arrays;

import java.util.*;

public class TotalSubArrayWithGivenXOR {

    public int solve(int[] nums, int B) {
        int xor = 0;
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
            if(map.containsKey(xor^B)) {
                res += map.get(xor^B);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return res;
    }

}
