package Graphs;

import java.util.*;

public class MaximumSumOfEdgeValueInGraph {
}

//class Solution {
//    public long maxScore(int n, int[][] edges) {
//        Arrays.sort(edges, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
//        List<List<Integer>> adjList = new ArrayList<>();
//        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
//        for(int[] edge: edges) {
//            adjList.get(edge[0]).add(edge[1]);
//        }
//
//    }
//}