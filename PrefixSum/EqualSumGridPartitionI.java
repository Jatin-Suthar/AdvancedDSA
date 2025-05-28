package PrefixSum;

public class EqualSumGridPartitionI {
    static class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            long totalSum = 0;
            int n = grid.length, m = grid[0].length;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    totalSum += grid[i][j];
                }
            }

            if((totalSum & 1) == 1) return false;

            if(isHorizontallyPossible(grid, n, m, totalSum / 2)) return true;
            return isVerticallyPossible(grid, n, m, totalSum / 2);
        }

        public boolean isHorizontallyPossible(int[][] grid, int n, int m, long target) {
            long sum = 0;
            for(int i = 0; i < n - 1; i++) {
                for(int j = 0; j < m; j++) {
                    sum += grid[i][j];
                }
                System.out.println("i: " + i + " | sum: " + sum);
                if(sum < 0) return false;
                if(sum == target) return true;
            }
            return false;
        }

        public boolean isVerticallyPossible(int[][] grid, int n, int m, long target) {
            long sum = 0;
            // Cut can happen after column 0 to column m-2
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n; j++) {
                    sum += grid[j][i];
                }
                System.out.println("i: " + i + " | sum: " + sum);
                if(sum < 0) return false;
                if(sum == target) return true;
            }
            return false;
        }
    }
}
