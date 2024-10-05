package DynamicProgrammingPatterns.Linear;

import java.util.*;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        for(int num: arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
        }
        return dp.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }

}
