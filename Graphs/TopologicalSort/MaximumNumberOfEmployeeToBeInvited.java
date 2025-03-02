package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumNumberOfEmployeeToBeInvited {

    public static void main(String[] args) {
        int[] favorite = {2,2,1,2};
        MaximumNumberOfEmployeeToBeInvitedSolution solution = new MaximumNumberOfEmployeeToBeInvitedSolution();
        System.out.println(solution.maximumInvitations(favorite));
    }

}

class MaximumNumberOfEmployeeToBeInvitedSolution {
    Stack<Integer> topologicalOrder = new Stack<>();
    public int maximumInvitations(int[] favorite) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = favorite.length;
        for (int j : favorite) {
            List<Integer> list = new ArrayList<>();
            list.add(j);
            adjList.add(list);
        }
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                topologicalSort(adjList, i, visited);
            }
        }
        System.out.println(topologicalOrder);
        return 0;
    }
    public void topologicalSort(List<List<Integer>> adjList, int vert, boolean[] visited) {
        visited[vert] = true;
        for(int neighbour: adjList.get(vert)) {
            if(!visited[neighbour]) {
                topologicalSort(adjList, neighbour, visited);
            }
        }
        topologicalOrder.push(vert);
    }
}

/*
In a way this query ask, what is the max group of employees you can get which are connected

0->2
1->2
2->1
3->2

*/
