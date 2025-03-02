package Graphs;

import java.util.*;

public class CourseScheduleIV {
}

class CourseScheduleIVSolution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        List<Boolean> res = new ArrayList<>(queries.length);
        for(int[] requisite: prerequisites) {
            adjList.get(requisite[0]).add(requisite[1]);
        }
        for (int[] query : queries) {
            res.add(dfs(new boolean[numCourses], adjList, query[0], query[1]));
        }
        return res;
    }
    public boolean dfs(boolean[] visited, List<List<Integer>> adjList, int source, int destination) {
        if(source==destination) return true;
        visited[source] = true;
        for(int neighbour: adjList.get(source)) {
            if(!visited[neighbour]) {
                if(dfs(visited, adjList, neighbour, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}