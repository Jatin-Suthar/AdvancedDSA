package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
	static boolean visited[][];
	static Set<List<String>> set;
	static List<String> pair;

	public static void main(String[] args) {
		int input[][] = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
		System.out.println(countDistinctIslands(input));
	}

	static int countDistinctIslands(int[][] grid) {
		int m = grid[0].length, n = grid.length;
		visited = new boolean[n][m];
		set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					pair = new ArrayList<>();
					pair.add(toString(0, 0));
					traverse(grid, i, j, i, j);
					set.add(pair);
				}
			}
		}
		return set.size();
	}

	public static void traverse(int[][] grid, int i, int j, int x0, int y0) {
		int dir[][] = { { 1, 0, -1, 0 }, { 0, 1, 0, -1 } };
		visited[i][j] = true;
		pair.add(toString(x0 - i, y0 - j));
		for (int k = 0; k < 4; k++) {
			int x = i + dir[0][k];
			int y = j + dir[1][k];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
				traverse(grid, x, y, x0, y0);
			}
		}
	}

	public static String toString(int x, int y) {
		return String.valueOf(x) + " " + String.valueOf(y);
	}
}
