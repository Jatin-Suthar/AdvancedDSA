package DynamicProgrammingPatterns.EventHandling;

public class MergeOperationForMinimumTimeTravel {
    public static void main(String[] args) {
        int l = 10;
        int n = 4;
        int k = 1;
        int[] position = {0,3,8,10};
        int[] time = {5,8,3,6};
        MergeOperationForMinimumTimeTravelSolution solution
                = new MergeOperationForMinimumTimeTravelSolution();
        System.out.println(solution.minTravelTime(l, n, k, position, time));
    }
}

class MergeOperationForMinimumTimeTravelSolution {
    Integer[][][] dp;
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        dp = new Integer[k+1][n][n+1];
        int[] timeSum = new int[n];
        for(int i=0; i<n; i++) {
            if(i == 0) timeSum[i] = time[i];
            else timeSum[i] = timeSum[i-1] + time[i];
        }
        return recur(position, k, 0, 0, timeSum);
    }
    public int recur(int[] posi, int k, int idx, int lastPosi, int[] timeSum) {
        int n = posi.length;
        if (idx == n - 1) {
            if (k == 0) return 0;
            return Integer.MAX_VALUE/2;
        }

        if (dp[k][idx][lastPosi] != null) return dp[k][idx][lastPosi];

        int timeCount = timeSum[idx] - (lastPosi > 0 ? timeSum[lastPosi - 1] : 0), ans = Integer.MAX_VALUE/2;
        int till = Math.min(n - 1, idx + k + 1);
        for (int j = idx + 1; j <= till; j++) {
            int temp = (posi[j] - posi[idx]) * timeCount + recur(posi, k - (j - idx - 1), j, idx + 1, timeSum);
            ans = Math.min(ans, temp);
        }
        return dp[k][idx][lastPosi] = ans;
    }
}
/*

[0,1,3]
[1,3,1]

 */