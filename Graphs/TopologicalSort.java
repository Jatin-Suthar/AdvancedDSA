package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	public static void main(String[] args) {
		//input goes here.
	}
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfs(adj, stack, visited, i);
		}
		int res[] = new int[V];
		int k = 0;
		while (!stack.isEmpty()) {
			res[k++] = stack.pop();
		}
		return res;
	}

	static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited, int i) {
		visited[i] = true;
		for (int val : adj.get(i)) {
			if (!visited[val])
				dfs(adj, stack, visited, val);
		}
		stack.add(i);
	}
}
