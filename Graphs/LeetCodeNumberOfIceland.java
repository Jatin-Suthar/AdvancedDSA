package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*

Question: Find Number of Iceland, connected 1's form an Iceland.

Input: [['1','1','1','1','0'],
  		['1','1','0','1','0'],
  		['1','1','0','0','0'],
  		['0','0','0','0','0']]
  		
Output: 1

Explanation: We can see that there is only one connected component.

Input: [["1","1","0","0","0"],
  		["1","1","0","0","0"],
  		["0","0","1","0","0"],
  		["0","0","0","1","1"]]
  		
Output: 1

Explanation: We can see that there is only one connected component.

Theorem to be used: BFS and DFS both can be used here.
 
*/

public class LeetCodeNumberOfIceland {
	public static void main(String[] args) {
		char[][] input =   {{'1','1','0','0','0'},
		            		{'1','1','0','0','0'},
		              		{'0','0','1','0','0'},
		              		{'0','0','0','1','1'}};
		System.out.println(numIslandsBFS(input));
	} 
    public static int numIslandsBFS(char[][] grid) {
        int ans=0;
        int n=grid.length, m=grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int row=0; row<n; row++) {
            for(int col=0; col<m; col++) {
                if(grid[row][col]=='1' && !visited[row][col]) {
                    ans++;
                    visited[row][col]=true;
                    queue.add(new int[] {row, col});
                    while(!queue.isEmpty()) {
                        int idx[] = queue.poll();
                        int i=idx[0], j=idx[1];
                        //north-west
                        if(i>0 && j>0 && grid[i-1][j-1]=='1' && !visited[i-1][j-1]) {
                            visited[i-1][j-1]=true;
                            queue.add(new int[] {i-1, j-1});
                        }
                        //north
                        if(i>0 && grid[i-1][j]=='1' && !visited[i-1][j]) {
                            visited[i-1][j]=true;
                            queue.add(new int[] {i-1, j});
                        }
                        //north-east
                        if(i>0 && j<m-1 && grid[i-1][j+1]=='1' && !visited[i-1][j+1]) {
                            visited[i-1][j+1]=true;
                            queue.add(new int[] {i-1, j+1});
                        }
                        //east
                        if(j<m-1 && grid[i][j+1]=='1' && !visited[i][j+1]) {
                            visited[i][j+1]=true;
                            queue.add(new int[] {i, j+1});
                        }
                        //south-east
                        if(i<n-1 && j<m-1 && grid[i+1][j+1]=='1' && !visited[i+1][j+1]) {
                            visited[i+1][j+1]=true;
                            queue.add(new int[] {i+1, j+1});
                        }
                        //south
                        if(i<n-1 && grid[i+1][j]=='1' && !visited[i+1][j]) {
                            visited[i+1][j]=true;
                            queue.add(new int[] {i+1, j});
                        }
                        //south-west
                        if(i<n-1 && j>0 && grid[i+1][j-1]=='1' && !visited[i+1][j-1]) {
                            visited[i+1][j-1]=true;
                            queue.add(new int[] {i+1, j-1});
                        }
                        //west
                        if(j>0 && grid[i][j-1]=='1' && !visited[i][j-1]) {
                            visited[i][j-1]=true;
                            queue.add(new int[] {i, j-1});
                        }
                    }
                }
            }
        }
        return ans;
    }
}
