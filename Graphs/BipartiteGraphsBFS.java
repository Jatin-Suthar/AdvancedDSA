package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphsBFS {
	public static void main(String[] args) {
		List<List<Integer>> adList = new ArrayList<>(4);
		adList.add(Arrays.asList(2, 3));// 0
		adList.add(Arrays.asList(3));// 1
		adList.add(Arrays.asList(0, 3));// 2
		adList.add(Arrays.asList(0, 1, 2));// 3
		System.out.println(isBipartite(adList.size(), adList));
	}

	public static boolean BipartiteCheck(int nodevalue, Queue<Integer> queue, int colored[], List<List<Integer>> adj) {
		colored[nodevalue] = 0;
		queue.add(nodevalue);

		while (!queue.isEmpty()) {
			int node = queue.remove();
			for (Integer i : adj.get(node)) {
				if (colored[i] == -1) {
					queue.add(i);
					colored[i] = 1 - colored[node];
				} else {
					if (colored[i] == colored[node]) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static boolean isBipartite(int V, List<List<Integer>> adj) {
		Queue<Integer> queue = new LinkedList<>();
		int[] colored = new int[V];

		for (int i = 0; i < V; i++) {
			colored[i] = -1;
		}

		for (int i = 0; i < V; i++) {
			if (colored[i] == -1) {
				if (!BipartiteCheck(i, queue, colored, adj)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isBipartite(List<List<Integer>> adList) {
		Queue<Integer> queue = new LinkedList<>();
		int colors[] = new int[adList.size()];
		queue.add(0);
		colors[0] = 5;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			for (int i : adList.get(idx)) {
				if (colors[i] != 5 && colors[i] != 6) {
					queue.add(i);
					colors[i] = getColor(colors[idx]);
				} else if (colors[i] == colors[idx]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int getColor(int currentColor) {
		return (currentColor == 5) ? 6 : 5;
	}
}
