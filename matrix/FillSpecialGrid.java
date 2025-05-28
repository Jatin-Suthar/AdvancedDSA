package matrix;

import java.util.*;

public class FillSpecialGrid {
    public static void main(String[] args) {
        FillSpecialGridSolution solution = new FillSpecialGridSolution();
        int[][] grid = solution.specialGrid(3);
        for(int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class FillSpecialGridSolution {
    int num = 0;
    public int[][] specialGrid(int n) {
        int len = (int) Math.pow(2, n);
        int[][] grid = new int[len][len];
        recur(grid, 0, len-1, len);
        return grid;
    }
    public void recur(int[][] grid, int i, int j, int len) {
        int mid = len/2;
        if(mid>1) {
            recur(grid, i, j, mid);
            recur(grid, i+mid, j, mid);
            recur(grid, i+mid, j - mid, mid);
            recur(grid, i, j - mid, mid);
        } else {
            fill(grid, i, j);
        }
    }
    public void fill(int[][] grid, int i, int j) {
        grid[i][j] = num++;
        grid[i+1][j] = num++;
        grid[i+1][j-1] = num++;
        grid[i][j-1] = num++;
    }
}



/*

63

n = 2;
len = 4;
num = 16

0 - 3 | 4 - 7 | 8 - 11 | 12 - 15



[
  [0,0,0,0],
  [0,0,0,0],
  [0,0,0,0],
  [0,0,0,0]
]


*/