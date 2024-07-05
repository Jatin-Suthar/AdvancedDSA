package Arrays;

import java.util.*;

public class LargestSubArrayWithZeroSum {

    public static void main(String[] args) {
        int arr[] = {-1, 1, -1, 1};
        System.out.println(maxLen(arr, arr.length));
    }

    int maxLenDesi(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(map.get(sum)!=null) {
                len = Math.max(len, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
            if(arr[i]==0) {
                len = Math.max(len, 1);
            }
        }
        return len;
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
