package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
	public static void main(String[] args) {
//		int[][] input =   {{1,1,1,0,0},
//			        	   {1,1,1,0,0},
//			          	   {0,1,1,0,0},
//			               {0,0,0,1,1}};
		
		int[][] input = {{0,0,0},
						 {0,0,0}};
		System.out.println(Arrays.deepToString(floodFill(input, 0, 0, 0)));
	}
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int n=image.length, m=image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        boolean visited[][] = new boolean[n][m];
        int target = image[sr][sc];
        while(!queue.isEmpty()) {
            int idx[] = queue.poll();
            int i=idx[0], j=idx[1];
            image[i][j]=color;
            //north
            if(i>0 && image[i-1][j]==target && !visited[i-1][j]) {
                visited[i-1][j]=true;
                queue.add(new int[] {i-1, j});
            }
            //east
            if(j<m-1 && image[i][j+1]==target && !visited[i][j+1]) {
                visited[i][j+1]=true;
                queue.add(new int[] {i, j+1});
            }
            //south
            if(i<n-1 && image[i+1][j]==target && !visited[i+1][j]) {
                visited[i+1][j]=true;
                queue.add(new int[] {i+1, j});
            }
            //west
            if(j>0 && image[i][j-1]==target && !visited[i][j-1]) {
                visited[i][j-1]=true;
                queue.add(new int[] {i, j-1});
            }
        }
        return image;
    }
}
