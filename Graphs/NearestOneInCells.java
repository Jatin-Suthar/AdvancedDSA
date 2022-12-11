package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Axis{
    int x;
    int y;
    Axis(int x, int y) {this.x=x;this.y=y;}
}

class Helper {
    Axis p;
    int c;
    Helper(Axis p, int c) {
        this.p=p;
        this.c=c;
    }
}



public class NearestOneInCells {
	
	public static void main(String[] args) {
		int a[][] = {{0, 1, 1, 0},
					 {1, 1, 0, 0},
					 {0, 0, 1, 1}};
		System.out.println(nearest(a));
	}
    //Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest(int[][] grid)
    {
        Queue<Helper> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int dir1[]={-1, 0, 1, 0};
        int dir2[]={0, 1, 0, -1};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    q.add(new Helper(new Axis(i, j), 0));
                    grid[i][j]=0;
                    visited[i][j]=true;
                }
            } 
        }
        
        while(!q.isEmpty()) {
            Helper h = q.poll();
            Axis idx = h.p;
            int c=h.c;
            for(int i=0; i<4; i++) {
                int a = idx.x+dir1[i]; int b = idx.y+dir2[i];
                if(a>=0 && a<grid.length && b>=0 && b<grid[0].length) {
                    if(grid[a][b]==0 && !visited[a][b]) {
                        grid[a][b] = c+1;
                        q.add(new Helper(new Axis(a, b), c+1));
                    }
                }
            }
        }
        
        return grid;
    }
}
