package Graphs;

public class NumberOfEnclaves {
	public static void main(String[] args) {
		int input[][] = { { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.println(numEnclaves(input));
	}

	static boolean visited[][];

	public static int numEnclaves(int[][] grid) {
		int m = grid[0].length, n = grid.length;
		visited = new boolean[n][m];
		for (int i = 0; i < m; i++) {
			if (grid[0][i] == 1 && !visited[0][i]) {
				traverse(grid, 0, i);
			}
		}
		for (int i = 1; i < n; i++) {
			if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
				traverse(grid, i, m - 1);
			}
		}
		for (int i = m - 2; i >= 0; i--) {
			if (grid[n - 1][i] == 1 && !visited[n - 1][i]) {
				traverse(grid, n - 1, i);
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (grid[i][0] == 1 && !visited[i][0]) {
				traverse(grid, i, 0);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (grid[i][j] == 1 && !visited[i][j])
					ans++;

		return ans;
	}

	public static void traverse(int[][] grid, int i, int j) {
		int dir[][] = { { 1, 0, -1, 0 }, { 0, 1, 0, -1 } };
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + dir[0][k];
			int y = j + dir[1][k];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y])
				traverse(grid, x, y);
		}
	}
}
