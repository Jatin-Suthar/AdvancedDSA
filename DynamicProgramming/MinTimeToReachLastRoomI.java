package DynamicProgramming;

import java.util.*;

public class MinTimeToReachLastRoomI {
    public static void main(String[] args) {
        int[][] moveTime =
        {
                {94,79,62,27,69,84},
                {6,32,11,82,42,30}
        };
        MinTimeToReachLastRoomISolution solution = new MinTimeToReachLastRoomISolution();
        System.out.println(solution.minTimeToReach(moveTime));
    }
}

class MinTimeToReachLastRoomISolution {
    Integer[][] dp;
    int n, m;
    public int minTimeToReach(int[][] moveTime) {
        n = moveTime.length; m = moveTime[0].length;
        dp = new Integer[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return minTime(moveTime, 0, 0, 0);
    }
    public int minTime(int[][] moveTime, int currTime, int i, int j) {
        if(i==n-1 && j==m-1) return currTime;

        if(dp[i][j] <= currTime) return Integer.MAX_VALUE;
        dp[i][j] = currTime;

        int ans = Integer.MAX_VALUE;

        if(i-1>=0) {
            int vert = Math.max(moveTime[i-1][j], currTime)+1;
            ans = Math.min(minTime(moveTime, vert, i-1, j), ans);
        }
        if(j-1>=0) {
            int hori = Math.max(moveTime[i][j-1], currTime)+1;
            ans = Math.min(minTime(moveTime, hori, i, j-1), ans);
        }
        if(i+1<n) {
            int vert = Math.max(moveTime[i+1][j], currTime)+1;
            ans = Math.min(minTime(moveTime, vert, i+1, j), ans);
        }
        if(j+1<m) {
            int hori = Math.max(moveTime[i][j+1], currTime)+1;
            ans = Math.min(minTime(moveTime, hori, i, j+1), ans);
        }
        return ans;
    }
}
/*
[
    [94,79,62,27,69,84],
    [6,32,11,82,42,30]
]
currTime = 85

 */