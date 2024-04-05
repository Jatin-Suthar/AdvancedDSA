package Graphs;

import java.util.Arrays;

public class NearestCellHavingOneDfs {

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},
                        {1,1,0,0},
                        {0,0,1,1}};
        Solution_NearestCellHavingOneDfs solution = new Solution_NearestCellHavingOneDfs();
        System.out.println(Arrays.deepToString(solution.nearest(grid)));
    }

}

class Solution_NearestCellHavingOneDfs {
    int[] ver = {-1, 0, 1, 0};
    int[] hor = {0, 1, 0, -1};
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int[][] nums = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                nums[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j]==1) {
                    dfs(nums, grid, visited, 0, i, j);
                    visited[i][j]=true;
                }
            }
        }
        return nums;
    }
    public void dfs(int[][] nums, int[][] grid, boolean[][] visited, int counter, int i, int j) {
        visited[i][j]=true;
        nums[i][j]=Math.min(nums[i][j], counter);
        for(int idx=0; idx<4; idx++) {
            int ith = i+ver[idx];
            int jth = j+hor[idx];
            if(ith<0 || ith>=grid.length || jth<0 || jth>=grid[0].length) {
                continue;
            }
            if(!visited[ith][jth] && grid[ith][jth]==0) {
                dfs(nums, grid, visited, counter+1, ith, jth);
            }
        }
        visited[i][j]=false;
    }
}