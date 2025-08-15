package Graphs.ShortestPaths;

import java.util.*;

public class NumberOfWaysToArriveAtDestinations {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(new Solution().countPaths(n, roads));
    }
    static class Solution {
        static final int MOD = 1_000_000_007;
        public int countPaths(int n, int[][] roads) {
            List<List<int[]>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] road : roads) {
                adjList.get(road[0]).add(new int[]{road[1], road[2]});
                adjList.get(road[1]).add(new int[]{road[0], road[2]});
            }

            return ways(n, adjList, 0);
        }
        public int ways(int n, List<List<int[]>> adjList, int src) {
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[src] = 0;

            long[] count = new long[n];
            count[src] = 1;

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    Comparator.comparingLong((Pair p) -> p.dist)
            );
            pq.add(new Pair(0, src));

            while (!pq.isEmpty()) {
                Pair cNode = pq.poll();
                int u = cNode.node;
                long d = cNode.dist;

                if (d > dist[u]) continue; // stale entry

                for (int[] vNode : adjList.get(u)) {
                    int v = vNode[0];
                    int vD = vNode[1];

                    long newDist = dist[u] + vD;
                    if (dist[u] != Long.MAX_VALUE && newDist < dist[v]) {
                        dist[v] = newDist;
                        count[v] = count[u];
                        pq.add(new Pair(dist[v], v));
                    } else if (newDist == dist[v]) {
                        count[v] = (count[v] + count[u]) % MOD;
                    }
                }
            }
            return (int) (count[n - 1] % MOD);
        }

        static class Pair {
            long dist;
            int node;
            public Pair(long dist, int node) {
                this.dist = dist;
                this.node = node;
            }
        }
    }
}
