package Backtracking;

import java.util.*;

public class RatInMaze {

}

class Solution {;
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        if(m[0][0]==0) return list;
        recur(m, n, 0, 0, "", list, new boolean[n][n]);
        return list;
    }

    public static void recur(int[][] nums, int len, int i, int j, String carry, ArrayList<String> list, boolean visited[][]) {
        if(i==len-1 && j==len-1) {
            list.add(carry);
            return;
        }

        visited[i][j]=true;

        if(i-1>=0 && nums[i-1][j]==1 && !visited[i-1][j]) {
            recur(nums, len, i-1, j, carry + "U", list, visited);
        }
        if(j+1<len && nums[i][j+1]==1 && !visited[i][j+1]) {
            recur(nums, len, i, j+1, carry + "R", list, visited);
        }
        if(i+1<len && nums[i+1][j]==1 && !visited[i+1][j]) {
            recur(nums, len, i+1, j, carry + "D", list, visited);
        }
        if(j-1>=0 && nums[i][j-1]==1 && !visited[i][j-1]) {
            recur(nums, len, i, j-1, carry + "L", list, visited);
        }

        visited[i][j]=false;
    }
}