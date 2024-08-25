package DynamicProgrammingPatterns.Linear;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
}

class MaximumLengthOfPairChainSolution {
    Integer[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        dp = new Integer[pairs.length][2002];
        return recur(pairs, 0, true, 0);
    }


    public int recur(int[][] pairs, int idx, boolean isFirst, int prev) {
        if(idx >= pairs.length) {
            return 0;
        }
        if(dp[idx][prev+1000]!=null) return dp[idx][prev+1000];
        int max = 0;
        if(isFirst || prev < pairs[idx][0]) {
            max = Math.max(max, 1+recur(pairs, idx+1, false, pairs[idx][1]));
        }
        return dp[idx][prev+1000] = Math.max(max, recur(pairs, idx+1, isFirst, prev));
    }
}