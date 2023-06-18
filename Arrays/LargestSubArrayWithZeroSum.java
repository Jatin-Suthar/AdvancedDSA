package Arrays;

import java.util.*;

public class LargestSubArrayWithZeroSum {

    public static void main(String[] args) {
        int arr[] = {-1, 1, -1, 1};
        System.out.println(maxLen(arr, arr.length));
    }

    public static int maxLen(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum==0) {
                ans = i+1;
            } else {
                if(map.containsKey(sum)) {
                    ans = Math.max(ans, i-map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return ans;
    }

}
