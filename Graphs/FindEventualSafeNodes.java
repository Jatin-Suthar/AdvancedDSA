package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualSafeNodes {
	public static void main(String[] args) {
		List<List<Integer>> adList = new ArrayList<>(10);
		adList.add(Arrays.asList(1, 2));// 0
		adList.add(Arrays.asList(2, 3));// 1
		adList.add(Arrays.asList(5));// 2
		adList.add(Arrays.asList(0));// 3
		adList.add(Arrays.asList(5));// 4
		adList.add(Arrays.asList());// 5
		adList.add(Arrays.asList());// 6
		System.out.println(eventualSafeNodes(adList.size(), adList));
	}

	public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adList) {
		List<Integer> eventualSafeNodes = new ArrayList<>();
		boolean visited[] = new boolean[V];
		boolean pathVis[] = new boolean[V];
		boolean checks[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(adList, i, visited, pathVis, checks);
			}
		}
		for (int i = 0; i < V; i++) {
			if (checks[i])
				eventualSafeNodes.add(i);
		}
		return eventualSafeNodes;
	}

	public static boolean dfs(List<List<Integer>> adList, int i, boolean[] visited, boolean[] pathVis,
			boolean[] checks) {
		visited[i] = true;
		pathVis[i] = true;
		checks[i] = false;
		for (int val : adList.get(i)) {
			if (!visited[val]) {
				if (dfs(adList, val, visited, pathVis, checks))
					return true;
			} else if (pathVis[val]) {
				return true;
			}
		}
		pathVis[i] = false;
		checks[i] = true;
		return false;
	}
}

/*
 * 0 -> 1, 2 1 -> 2, 3 2 -> 5 3 -> 0 4 -> 5 5 -> 6 ->
 */