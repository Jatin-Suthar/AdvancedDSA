package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubstringWithAtMostTwoDistinctChars {
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(totalElements(arr));
    }
    public static int totalElements(Integer[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, n = arr.length, max = 0;
        for(int end = 0; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            if(map.size() > 2) {
                max = Math.max(end - start, max);
                while(map.size()>2) {
                    int count = map.get(arr[start])-1;
                    if(count == 0) {
                        map.remove(arr[start]);
                    } else {
                        map.put(arr[start], count);
                    }
                    start++;
                }
            }
        }
        return Math.max(n - start, max);
    }
}