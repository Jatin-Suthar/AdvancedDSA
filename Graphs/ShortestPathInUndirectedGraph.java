package Graphs;

import java.io.IOException;
import java.util.*;

public class ShortestPathInUndirectedGraph {
}

class Solution_ShortestPathInUndirectedGraph {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for(int[] edge: edges) {
            List<Integer> list1 = adjMap.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            adjMap.put(edge[0], list1);
            List<Integer> list2 = adjMap.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            adjMap.put(edge[1], list2);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> list = adjMap.getOrDefault(cur, new ArrayList<>());
            for (int next : list) {
                if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                dist[i]=-1;
            }
        }

        return dist;
    }
}