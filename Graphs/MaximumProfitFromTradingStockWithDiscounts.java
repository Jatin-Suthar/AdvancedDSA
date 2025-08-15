package Graphs;

import java.util.*;

public class MaximumProfitFromTradingStockWithDiscounts {
    public static void main(String[] args) {
        int n = 3;
        int[] present = {4,6,8};
        int[] future = {7,9,11};
        int[][] hierarchy = {{1,2},{1,3}};
        int budget = 10;
        System.out.println(new Solution().maxProfit(n, present, future, hierarchy, budget));
    }
    static class Solution {
        public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
            List<List<Integer>> adjList = new ArrayList<>();
            for(int i=0; i<n; i++) {
                adjList.add(new ArrayList<>());
            }
            for(int[] edge: hierarchy)
                adjList.get(edge[0]-1).add(edge[1]-1);
            int ans = 0;
            for(int i=0; i<n; i++) {
                ans = Math.max(ans, (future[i] - present[i]) + recur(present, future, adjList, budget - present[i], i));
            }
            return ans;
        }
        public int recur(int[] present, int[] future, List<List<Integer>> adjList, int budget, int u) {
            if(budget <= 0) return 0;
            int ans = 0;
            for(int v: adjList.get(u)) {
                int discounted = (future[v]-(present[v]>>1));
                int direct = (future[v]-present[v]);
                int maxProfit = 0;
                if(discounted <= budget) {
                    maxProfit = discounted+recur(present, future, adjList, budget - present[v], v);
                }
                maxProfit = Math.max(maxProfit, direct + recur(present, future, adjList, budget-direct, v));
                ans += maxProfit;
            }
            return ans;
        }
    }
/*
3+6+7
*/
}
