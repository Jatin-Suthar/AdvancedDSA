package Graphs.TopologicalSort;

import java.util.*;

public class ShortestPathInDag {

    public static void main(String[] args) {
        int V = 6, E = 7;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        ShortestPathInDagSolution solution = new ShortestPathInDagSolution();
        System.out.println(Arrays.toString(solution.shortestPath(V, E, edges)));
    }

}

class ShortestPathInDagSolution {
    Stack<Integer> stack = new Stack<>();
    public int[] shortestPath(int V, int E, int[][] edges) {
        Map<Integer, List<AdjNode>> map = new HashMap<>();
        for (int i = 0; i < E; i++) {
            List<AdjNode> list = map.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(new AdjNode(edges[i][1], edges[i][2]));
            map.put(edges[i][0], list);
        }
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(map, i, visited);
            }
        }
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(map.get(v)!=null) {
                for(AdjNode adj : map.get(v)) {
                    if(res[v]!=Integer.MAX_VALUE) {
                        res[adj.node] = Math.min(res[adj.node], res[v] + adj.weight);
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
    public void dfs(Map<Integer, List<AdjNode>> map, int v, boolean[] visited) {
        visited[v] = true;
        if(map.get(v)!=null) {
            for(AdjNode adjNode : map.get(v)) {
                if(!visited[adjNode.node]) {
                    dfs(map, adjNode.node, visited);
                }
            }
        }
        stack.push(v);
    }
}

class AdjNode {
    int node;
    int weight;
    public AdjNode(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}