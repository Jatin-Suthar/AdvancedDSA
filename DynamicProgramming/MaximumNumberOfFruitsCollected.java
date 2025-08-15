package DynamicProgramming;

public class MaximumNumberOfFruitsCollected {
    public static void main(String[] args) {
        int[][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        System.out.println(new Solution().maxCollectedFruits(fruits));
    }
    static class Solution {
        public int maxCollectedFruits(int[][] fruits) {
            int n = fruits.length;
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                diagonalSum += fruits[i][i];
            }

            int[][] rightDirs = {{1, -1}, {1, 0}, {1, 1}};
            int[][] leftDirs = {{-1, 1}, {0, 1}, {1, 1}};

            Integer[][] dpRight = new Integer[n][n];
            Integer[][] dpLeft = new Integer[n][n];

            int rightPath = dfs(fruits, 0, n - 1, dpRight, rightDirs, true);
            int leftPath = dfs(fruits, n - 1, 0, dpLeft, leftDirs, false);

            return diagonalSum + rightPath + leftPath;
        }

        private int dfs(int[][] grid, int row, int col, Integer[][] dp, int[][] directions, boolean isRight) {
            int n = grid.length;

            if (row == n - 1 && col == n - 1) return 0;
            if (dp[row][col] != null) return dp[row][col];

            int maxFruits = 0;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isInBounds(newRow, newCol, n)) {
                    boolean isValid = isRight
                            ? (newRow < newCol || (newRow == n - 1 && newCol == n - 1))
                            : (newRow > newCol || (newRow == n - 1 && newCol == n - 1));

                    if (isValid) {
                        int collected = grid[row][col] + dfs(grid, newRow, newCol, dp, directions, isRight);
                        maxFruits = Math.max(maxFruits, collected);
                    }
                }
            }

            return dp[row][col] = maxFruits;
        }

        private boolean isInBounds(int i, int j, int n) {
            return i >= 0 && j >= 0 && i < n && j < n;
        }
    }
/*
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33
*/
}
