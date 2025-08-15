package Graphs.ShortestPaths;

import java.util.*;

public class CheapestFlightWithinKStops {
    static class Solution {
        int min = Integer.MAX_VALUE;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<Pair>> adjList = new ArrayList<>();
            for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
            for(int[] flight: flights) {
                adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
            }
            cheapestPriceToReach(n, adjList, src, dst, k);
            return min;
        }
        public void cheapestPriceToReach(int n, List<List<Pair>> adjList, int src, int dst, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[1]));
            int[] cheap = new int[n];
            Arrays.fill(cheap, Integer.MAX_VALUE);
            pq.add(new int[] {src, 0, k});
            cheap[src] = 0;
            while(!pq.isEmpty()) {
                int[] node = pq.poll();
                int u = node[0];
                int p = node[1];
                int c = node[2];
                if(k == 0) continue;
                for(Pair v: adjList.get(u)) {
                    int vU = v.node;
                    int vP = v.price;
                    int total = p + vP;
                    if(total < cheap[vU] || c > 0) {
                        cheap[vU] = Math.min(cheap[vU], total);
                        if(vU == dst) {
                            min = Math.min(min, p+vP);
                        }
                        pq.add(new int[] {vU, cheap[vU], c-1});
                    } else if(c == 0 && vU == dst) {
                        min = Math.min(min, p + vP);
                    }
                }
            }
        }
        class Pair {
            int node;
            int price;
            public Pair(int node, int price) {
                this.node = node;
                this.price = price;
            }
        }
    }
}
