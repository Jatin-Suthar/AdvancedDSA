package DynamicProgramming;

import java.util.*;

public class StockBuyAndSell {

    public static void main(String[] args) {

//        int[] arr = {822, 754, 1689, 305, 214, 782, 1463, 1432, 1382, 1734, 948, 231, 210, 1676, 877, 670, 1384, 725, 1370, 412, 724, 371, 928, 358, 533, 1031, 850, 1555, 1064, 845, 1692, 514, 630, 1333, 1640, 315, 1639, 1792, 1779, 1325, 1619, 1400, 378, 145, 913, 901, 1652, 530, 1259, 880, 303, 685, 1586};
        int[] arr = {100,180,260,310,40,535,695};
        StockBuyAndSellSolution solution = new StockBuyAndSellSolution();
        System.out.println(solution.stockBuySell(arr, arr.length));

    }

}

class StockBuyAndSellSolution{

    ProfitPair[][] dp;

    ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        dp = new ProfitPair[n+1][n+1];
        return dfsDp(A, n, 0, 1).days;
    }

    public ProfitPair dfsDp(int[] nums, int n, int s, int e) {
        if(s>=n-1 || e>=n) {
            return new ProfitPair(0, new ArrayList<>());
        }
        if(dp[s][e] != null) {
            return dp[s][e];
        }
        int max = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> res;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=e; i<n; i++) {
            int profitOnThisDay = nums[i]-nums[s];
            ProfitPair profitPair = dfsDp(nums, n, i+1, i+2);
            if(profitPair.profit+profitOnThisDay>max) {
                max = profitPair.profit+profitOnThisDay;
                list.clear();
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(s);
                temp.add(i);
                list.add(temp);
                list.addAll(profitPair.days);
            }
        }
        ProfitPair profitPair = dfsDp(nums, n, s+1, e+1);
        if(profitPair.profit>max) {
            max = profitPair.profit;
            res = new ArrayList<>(profitPair.days);
        } else {
            res = new ArrayList<>(list);
        }
        return dp[s][e] = new ProfitPair(max, res);
    }

    public ProfitPair dfs(int[] nums, int n, int idx, int totalProfit, ArrayList<ArrayList<Integer>> list) {
        if(idx==n-1 || idx==n) {
            return new ProfitPair(totalProfit, new ArrayList<>(list));
        }
        int max = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=idx+1; i<n; i++) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(idx);
            pair.add(i);
            list.add(pair);
            ProfitPair profitPair = dfs(nums, n, i+1, totalProfit+(nums[i]-nums[idx]), new ArrayList<>(list));
            if(profitPair.profit>max) {
                max = profitPair.profit;
                res = profitPair.days;
            }
            list.remove(list.size()-1);
        }
        ProfitPair profitPair = dfs(nums, n, idx+1, totalProfit, new ArrayList<>(list));
        if(profitPair.profit>max) {
            max = profitPair.profit;
            res = profitPair.days;
        }
        return new ProfitPair(max, res);
    }

}

class ProfitPair {
    int profit;
    ArrayList<ArrayList<Integer>> days;
    public ProfitPair(int profit, ArrayList<ArrayList<Integer>> days) {
        this.profit = profit;
        this.days = days;
    }
}