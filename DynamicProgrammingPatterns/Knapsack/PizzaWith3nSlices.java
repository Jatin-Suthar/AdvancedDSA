package DynamicProgrammingPatterns.Knapsack;

public class PizzaWith3nSlices {
    public static void main(String[] args) {
        int[] slices = {1,2,3,4,5,6};
        PizzaWith3nSlicesSolution solution = new PizzaWith3nSlicesSolution();
        System.out.println(solution.maxSizeSlices(slices));
    }
}

class PizzaWith3nSlicesSolution {
    public int pickPizza(int[] slices, int start, int end, int slicesLeft, Integer[][] dp) {
        if(slicesLeft==0 || start>=end) return 0;
        if(dp[start][slicesLeft]!=null) return dp[start][slicesLeft];
        int pick = slices[start] + pickPizza(slices, start+2, end, slicesLeft-1, dp);
        int dont = pickPizza(slices, start+1, end, slicesLeft, dp);
        return dp[start][slicesLeft] = Math.max(pick, dont);
    }
    public int maxSizeSlices(int[] slices) {
        int n = slices.length, slicesLeft = slices.length / 3;
        Integer[][] dp = new Integer[n][slicesLeft+1];
        int pickFirst = pickPizza(slices, 0, n-1, slicesLeft, dp);
        dp = new Integer[n][slicesLeft+1];
        int dontPick = pickPizza(slices, 1, n, slicesLeft, dp);
        return Math.max(pickFirst, dontPick);
    }
}