package Arrays;

import java.util.*;

public class CountPairsOfGivenSum {

    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(map.containsKey(arr[i])) {
                ans+=map.get(arr[i]);
            }
            map.put(k-arr[i], map.getOrDefault(k-arr[i], 0)+1);
        }
        return ans;
    }

}
