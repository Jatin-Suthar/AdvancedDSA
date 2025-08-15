package Graphs.ShortestPaths;

import java.util.*;

public class BellmanFordsAlgorithm {
    static class Solution {
        int MAX = 100000000;
        public int[] bellmanFord(int V, int[][] edges, int src) {
            // code here
            int[] dist = new int[V];
            Arrays.fill(dist, MAX);
            dist[src] = 0;
            for(int i=0; i<V-1; i++) {
                for(int[] edge: edges) {
                    int u = edge[0], v = edge[1], w = edge[2];
                    if(dist[u] != MAX && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
            //to handle negative cycle case
            for(int[] edge: edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if(dist[u] != MAX && dist[u] + w < dist[v]) {
                    return new int[] {-1};
                }
            }
            return dist;
        }
    }
}
