package Greedy;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfOperationToMakeArrayEmpty {

    public static void main(String[] args) {
        int nums[] = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        Solution_MNOOTMAE solution = new Solution_MNOOTMAE();
        System.out.println(solution.minOperations(nums));
    }

}

class Solution_MNOOTMAE {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int res = 0;
        for(int key: map.keySet()) {
            int finalV = map.get(key);
            int n = finalV;
            while(n>1) {
                if(n%3==0) {
                    res += n/3;
                    n %= 3;
                } else {
                    n -= 2;
                    res += 1;
                }
            }
        }
        return res;
    }
}
