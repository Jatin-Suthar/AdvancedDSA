package Graphs;

import java.util.*;

public class MaximumWeightedKEdgePath {
    public static void main(String[] args) {
        int n = 4, k = 2, t = 331;
        int[][] edges = {{0,2,3},{1,3,10},{0,3,5},{2,3,10},{0,1,1}};
        MaximumWeightedKEdgePathSolution solution = new MaximumWeightedKEdgePathSolution();
        System.out.println(solution.maxWeight(n, edges, k, t));
    }
}

class MaximumWeightedKEdgePathSolution {
    int ans = -1;
    Boolean[][] dp;
    public int maxWeight(int n, int[][] edges, int k, int t) {
        if(k==0) return 0;
        Arrays.sort(edges, Comparator
                .comparingInt((int[] edge) -> edge[0])
                .thenComparingInt(edge -> edge[1]));
        int sum = 0;
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            sum += edge[2];
        }
        dp = new Boolean[n+1][n+1];
        for(int i=0; i<n; i++) {
            dfs(adjList, i, 0, new ArrayList<>(), k, t, 0);
        }
        return ans;
    }

    private void dfs(List<List<Node>> adjList, int v, int sum, List<Integer> sumList, int k, int t, int st) {
        sumList.add(sum);
        boolean isSub = false;
        if(sumList.size() > k && (sum - sumList.get(st)) < t) {
            ans = Math.max(ans, sum-sumList.get(st));
            isSub = true;
        }
        for(Node neighbour: adjList.get(v)) {
            if (Boolean.TRUE.equals(dp[v][neighbour.v])) return;
            dp[v][neighbour.v] = true;
            dfs(adjList, neighbour.v, sum+neighbour.w, sumList, k, t, (isSub) ? st+1 : st);
        }
        sumList.removeLast();
    }

    static class Node {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}