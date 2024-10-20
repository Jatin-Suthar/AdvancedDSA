package DynamicProgrammingPatterns.Knapsack;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public static void main(String[] args) {
        int[] scores = {4,5,6,5}, ages = {2,1,2,1};
        BestTeamWithNoConflictsSolution solution = new BestTeamWithNoConflictsSolution();
        System.out.println(solution.bestTeamScore(scores, ages));
    }

}

class BestTeamWithNoConflictsSolution {
    Integer[][] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        dp = new Integer[n][n+1];
        TeamScore[] teamScores = new TeamScore[n];
        for(int i = 0; i < n; i++) {
            teamScores[i] = new TeamScore(scores[i], ages[i]);
        }
        Arrays.sort(teamScores, (a, b) -> (a.age == b.age) ? a.score - b.score : a.age - b.age);
        return recur(teamScores, 0, -1);
    }
    public int recur(TeamScore[] teamScores, int idx, int prev) {
        if(idx==teamScores.length) {
            return 0;
        }
        if(dp[idx][prev+1]!=null) {
            return dp[idx][prev+1];
        }
        int max = Integer.MIN_VALUE;
        if(prev==-1 || teamScores[prev].score<=teamScores[idx].score) {
            max = teamScores[idx].score+recur(teamScores, idx+1, idx);
        }
        return dp[idx][prev+1] = Math.max(max, recur(teamScores, idx+1, prev));
    }
}

class TeamScore {
    int score;
    int age;
    public TeamScore(int score, int age) {
        this.score = score;
        this.age = age;
    }
}