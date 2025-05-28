package Graphs;

import java.util.*;

public class UnitConversionI {
}

class Solution {
    int MODULO = 1000000007;
    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length+1;
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] conversion: conversions) {
            adjList.get(conversion[0]).add(new Pair(conversion[1], conversion[2]));
        }
        int[] res = new int[n];
        recur(adjList, 0, 1l, res);
        return res;
    }
    public void recur(List<List<Pair>> adjList, int v, long currSum, int[] res) {
        res[v] = (int) (currSum)%MODULO;
        List<Pair> neighbours = adjList.get(v);
        for(Pair neighbour: neighbours) {
            recur(adjList, neighbour.node,
                    (((currSum)%MODULO)*((neighbour.weight)%MODULO))%MODULO, res);
        }
    }
    static class Pair {
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}