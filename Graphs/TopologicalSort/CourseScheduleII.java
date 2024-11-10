package Graphs.TopologicalSort;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 3; int[][] prerequisites = {{0,1},{0,2},{1,2}};
        CourseScheduleIISolution solution = new CourseScheduleIISolution();
        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }

}

class CourseScheduleIISolution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> vertMap = new TreeMap<>();

        for(int[] prerequisite: prerequisites) {
            List<Integer> neighbours = vertMap.getOrDefault(prerequisite[1], new ArrayList<>());
            neighbours.add(prerequisite[0]);
            vertMap.put(prerequisite[1], neighbours);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(vertMap.getOrDefault(i, new ArrayList<>()));
        }
//        return findOrderBFS(adj);
        return findOrderDFS(adj);
    }
    Stack<Integer> stack = new Stack<>();
    public int[] findOrderDFS(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(dfs(adj, i, visited, pathVisited)) return new int[0];
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public boolean dfs(List<List<Integer>> adj, int v, boolean[] visited, boolean[] pathVisited) {
        visited[v] = true;
        pathVisited[v] = true;
        for(int neighbour: adj.get(v)) {
            if(!visited[neighbour]) {
                if(dfs(adj, neighbour, visited, pathVisited)) return true;
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }
        stack.push(v);
        pathVisited[v] = false;
        return false;
    }
    public int[] findOrderBFS(List<List<Integer>> adj) {
        int numCourses = adj.size();

        int[] inDegree = new int[numCourses];

        for (List<Integer> neighbours : adj) {
            for (int neighbour : neighbours) {
                inDegree[neighbour]++;
            }
        }

        // Queue to manage nodes with an in-degree of 0, i.e., no dependencies
        Queue<Integer> queue = new LinkedList<>();

        // Adding all nodes with 0 in-degree to the queue
        for (int i = 0; i < numCourses; i++) {
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

        if(topoSortOrder.size()!=numCourses) return new int[0];

        return topoSortOrder.stream().mapToInt(i->i).toArray();
    }
}