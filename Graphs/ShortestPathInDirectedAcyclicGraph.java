package Graphs;

import java.io.IOException;
import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution_ShortestPathInDirectedAcyclicGraph obj
                    = new Solution_ShortestPathInDirectedAcyclicGraph();
            int[] res = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

}

class Solution_ShortestPathInDirectedAcyclicGraph {

    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<PairDag>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            int w = edge[2];
            adj.get(v).add(new PairDag(u, w));
        }
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSort(stack, adj, visited, i);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (PairDag idx : adj.get(node)) {
                int w = idx.weight;
                int v = idx.node;
                if (distance[node] != Integer.MAX_VALUE) {
                    if (distance[node] + w < distance[v]) {
                        distance[v] = distance[node] + w;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    public void topologicalSort(Stack<Integer> stack, List<List<PairDag>> adj, boolean[] visited, int curr) {
        visited[curr] = true;
        for (PairDag vertex : adj.get(curr)) {
            int v = vertex.node;
            if (!visited[v]) {
                topologicalSort(stack, adj, visited, v);
            }
        }
        stack.push(curr);
    }
}

class PairDag {
    int node;
    int weight;

    public PairDag(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}