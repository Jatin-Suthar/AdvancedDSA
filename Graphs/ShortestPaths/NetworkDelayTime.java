package Graphs.ShortestPaths;

import java.util.*;

public class NetworkDelayTime {
    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<List<int[]>> adjList = new ArrayList<>();
            for(int i=0; i<n; i++) {
                adjList.add(new ArrayList<>());
            }
            for(int[] time: times) {
                adjList.get(time[0]).add(new int[] {time[1], time[2]});
                adjList.get(time[1]).add(new int[] {time[0], time[2]});
            }
            PriorityQueue<int[]> pq =
                    new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0])
                    .thenComparingInt((int[] a) -> a[1]));
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new int[] {0, k});
            dist[k] = 0;
            while(!pq.isEmpty()) {
                int[] node = pq.poll();
                int cDist = node[0];
                int cNode = node[1];
                for(int[] v: adjList.get(cNode)) {
                    int vDist = v[1];
                    int vNode = v[0];
                    if(cDist + vDist < dist[vNode]) {
                        dist[vNode] = cDist + vDist;
                        pq.add(new int[] {dist[vNode], vNode});
                    }
                }
            }
            int max = 0;
            for(int i=1; i<=n; i++) {
                max = Math.max(max, dist[i]);
            }
            return (max == Integer.MAX_VALUE) ? -1 : max;
        }
    }
}
