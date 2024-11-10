package Graphs.TopologicalSort;

import java.util.*;

/**
 * This class implements Kahn's Algorithm for performing a topological sort on a Directed Acyclic Graph (DAG).
 * Topological sorting is a linear ordering of vertices in a directed graph such that for every directed edge (u, v),
 * vertex u appears before vertex v in the ordering.
 * Kahn's Algorithm uses BFS (Breadth-First Search) to achieve this sorting.
 */
public class TopologicalSortBfsKahnsAlgo {

    /**
     * Function to perform a topological sort on a directed acyclic graph.
     * The graph is represented as an adjacency list, where each node points to a list of its neighboring nodes.
     *
     * @param adj - An adjacency list representing the directed graph.
     * @return An ArrayList of integers containing the vertices in topological order.
     */
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();  // Number of vertices in the graph

        // Array to keep track of the in-degree of each vertex.
        // In-degree of a vertex is the number of edges coming into it.
        int[] inDegree = new int[n];

        // Calculating in-degrees of all vertices
        for (ArrayList<Integer> neighbours : adj) {
            for (int neighbour : neighbours) {
                inDegree[neighbour]++;
            }
        }

        // Queue to manage nodes with an in-degree of 0, i.e., no dependencies
        Queue<Integer> q = new LinkedList<>();

        // Adding all nodes with 0 in-degree to the queue
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // List to store the topological order of the vertices
        ArrayList<Integer> topoSortOrder = new ArrayList<>();

        // Processing each node in the queue
        while (!q.isEmpty()) {
            int node = q.poll();  // Get the next node with 0 in-degree
            topoSortOrder.add(node);  // Add it to the topological sort order

            // For each neighbor of the current node, reduce their in-degree by 1
            ArrayList<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                inDegree[neighbour]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return topoSortOrder;  // Return the vertices in topological order
    }
}

