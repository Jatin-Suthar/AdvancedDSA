package Graphs;

import java.util.*;

public class DetectCycleInDirectedGraph {
}

class Solution_DetectCycleInDirectedGraph {
    // Function to detect cycle in a directed graph.
    boolean[] pathVis;
    boolean[] visited;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        visited = new boolean[V];
        pathVis = new boolean[V];
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(ArrayList<Integer> edge: adj) {
            List<Integer> list = (map.get(edge.get(0))!=null) ? map.get(edge.get(0)) : new ArrayList<>();
            list.add(edge.get(1));
            map.put(edge.get(0), list);
        }
        System.out.println(map);
        return dfs(map, map.firstKey());
    }
    public boolean dfs(TreeMap<Integer, List<Integer>> adj, int node) {
        pathVis[node]=true;
        visited[node]=true;
        for(int idx: adj.get(node)) {
            if(!visited[idx]) {
                dfs(adj, idx);
            } else if(pathVis[idx]) {
                return true;
            }
        }
        pathVis[node]=false;
        return false;
    }
}