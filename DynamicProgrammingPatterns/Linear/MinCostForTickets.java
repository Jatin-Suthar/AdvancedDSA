package DynamicProgrammingPatterns.Linear;

public class MinCostForTickets {

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        MinCostForTicketsSolution solution = new MinCostForTicketsSolution();
        System.out.println(solution.mincostTickets(days, costs));
    }

}

class MinCostForTicketsSolution {
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length+1];
        return recur(days, costs, 0);
    }
    int[] pass = {1, 7, 30};
    Integer[] dp;
    public int recur(int[] days, int[] costs, int idx) {
        if (idx == days.length) {
            return 0;
        }
        if(dp[idx] != null) {
            return dp[idx];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=2; i++) {
            int shift = idx;
            int limit = days[idx]+pass[i];
            while(shift<days.length && days[shift]<limit) {
                shift++;
            }
            ans = Math.min(ans, costs[i] + recur(days, costs, shift));
        }
        return dp[idx] = ans;
    }
}