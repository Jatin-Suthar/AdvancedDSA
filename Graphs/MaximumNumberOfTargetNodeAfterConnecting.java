package Graphs;

import java.util.*;

public class MaximumNumberOfTargetNodeAfterConnecting {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxTargetNodes(edges1, edges2, k)));
    }
    static class Solution {
        Integer[][] dp;
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            int n = edges1.length+1, m = edges2.length+1;
            int[] first = new int[n];
            if(k==0) {
                Arrays.fill(first, 1);
                return first;
            }
            List<List<Integer>> adj1 = new ArrayList<>();
            List<List<Integer>> adj2 = new ArrayList<>();
            for(int i=0; i<n; i++) adj1.add(new ArrayList<>());
            for(int i=0; i<m; i++) adj2.add(new ArrayList<>());
            for(int[] edge: edges1) {
                adj1.get(edge[0]).add(edge[1]);
                adj1.get(edge[1]).add(edge[0]);
            }
            for(int[] edge: edges2) {
                adj2.get(edge[0]).add(edge[1]);
                adj2.get(edge[1]).add(edge[0]);
            }
            Integer[][] dp1 = new Integer[m][k+1];
            int max = 0;
            for(int i=0; i<m; i++) {
                max = Math.max(max, dfs(adj2, k-1, i, new boolean[m], dp1));
            }
            Integer[][] dp2 = new Integer[n][k+1];
            for(int i=0; i<n; i++) {
                first[i] = 2 + max + dfs(adj1, k, i, new boolean[n], dp2);
            }
            return first;
        }
        public int dfs(List<List<Integer>> adj, int k, int u, boolean[] visited, Integer[][] dp) {
            if(k==0) return 0;
            visited[u] = true;
            if(dp[u][k]!=null) return dp[u][k];
            int count = 0;
            for(int neighbour: adj.get(u)) {
                if(!visited[neighbour]) {
                    count += (1+dfs(adj, k-1, neighbour, visited, dp));
                }
            }
            return dp[u][k] = count;
        }
    }
}
