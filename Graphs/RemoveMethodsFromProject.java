package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveMethodsFromProject {
/*
4
1
[[1,2],[0,1],[3,2]]
5
0
[[1,2],[0,2],[0,1],[3,4]]
3
2
[[1,2],[0,1],[2,0]]
 */
    public static void main(String[] args) {
        int n = 3;
        int k = 0;
        int[][] invocations = {{2,0}};
        RemoveMethodsFromProjectSolution solution = new RemoveMethodsFromProjectSolution();
        System.out.println(solution.remainingMethods(n, k, invocations));
    }

}

class RemoveMethodsFromProjectSolution {
    boolean[] unsafe;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        unsafe = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<invocations.length; i++) {
            adj.get(invocations[i][0]).add(invocations[i][1]);
        }
        dfs(adj, k, new boolean[n]);
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                makeSafe(adj, i, visited);
            }
        }
        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!unsafe[i]) {
                safe.add(i);
            }
        }
        return safe;
    }
    public void makeSafe(List<List<Integer>> adj, int k, boolean[] visited) {
        for(int num: adj.get(k)) {
            if (!visited[num]) {
                visited[num] = true;
                if(!unsafe[k] && unsafe[num]) {
                    unsafe[num] = false;
                }
                makeSafe(adj, num, visited);
            }
        }
    }
    public void dfs(List<List<Integer>> adj, int k, boolean[] visited) {
        unsafe[k]=true;
        visited[k] = true;
        for(int num: adj.get(k)) {
            if(!visited[num]) {
                dfs(adj, num, visited);
            }
        }
    }
}