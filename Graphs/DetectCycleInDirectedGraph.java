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
    public boolean isCyclicUsingBFS(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        for (List<Integer> neighbours : adj) {
            for (int neighbour : neighbours) {
                inDegree[neighbour]++;
            }
        }

        // Queue to manage nodes with an in-degree of 0, i.e., no dependencies
        Queue<Integer> queue = new LinkedList<>();

        // Adding all nodes with 0 in-degree to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // List to store the topological order of the vertices
        List<Integer> topoSortOrder = new ArrayList<>();

        // Processing each node in the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();  // Get the next node with 0 in-degree
            topoSortOrder.add(node);  // Add it to the topological sort order

            // For each neighbor of the current node, reduce their in-degree by 1
            List<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                inDegree[neighbour]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return topoSortOrder.size()!=V;  // Return the vertices in topological order
    }
}