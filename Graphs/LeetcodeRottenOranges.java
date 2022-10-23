package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeRottenOranges {
	public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int vis[][] = new int[n][m];
        int rot=0, fre=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(new int[] {i, j}, 0));
                    vis[i][j]=2;
                    rot++;
                }else {
                    vis[i][j]=grid[i][j];
                }
                if(grid[i][j]==1) fre++;
            }
        }
        if(fre==0) return 0;
        if(rot==0) return -1;
        int count=0;
        int tm=0;
        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()) {
            Pair p=q.poll();
            int idx[]=p.idx;
            tm = Math.max(p.minutes, count);
            for(int[] d: dir) {
                int val1 = idx[0] + d[0];
                int val2 = idx[1] + d[1];
                if(val1<n && val2<m && val1>=0 && val2>=0 && vis[val1][val2]==1) {
                    vis[val1][val2]=2;
                    q.add(new Pair(new int[] {val1, val2}, tm+1));
                    fre--;
                }
            }
        }
        if(fre>0) return -1;
        return tm;
    }
}

class Pair {
	int[] idx;
	int minutes;
	public Pair(int[] idx, int minutes) {
		this.idx=idx;
		this.minutes=minutes;
	}
}
