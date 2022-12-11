package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int a;
    int b;
    Point(int a, int b) {
        this.a=a;
        this.b=b;
    }
}

public class SurroundedRegionsBFS {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            System.out.println("x: "+0+"y: "+i);
            if(board[0][i]=='O') {
                board[0][i]='-';
                q.add(new Point(0, i));
                visited[0][i]=true;
            }
        }
        for(int i=1; i<n; i++) {
            if(board[i][m-1]=='O') {
                board[i][m-1]='-';
                q.add(new Point(i, m-1));
                visited[i][m-1]=true;
            }
        }
        for(int i=m-2; i>=0; i--) {
            System.out.println("x: "+(n-1)+"y: "+i);
            if(board[n-1][i]=='O') {
                board[n-1][i]='-';
                q.add(new Point(n-1, i));
                visited[n-1][i]=true;
            }
        }
        for(int i=n-2; i>=0; i--) {
            System.out.println("x: "+i+"y: "+0);
            if(board[i][0]=='O') {
                board[i][0]='-';
                q.add(new Point(i, 0));
                visited[i][0]=true;
            }
        }
        int dir[][] = {{1, 0, -1, 0},
                       {0, 1, 0, -1}};
        while(!q.isEmpty()) {
            Point p=q.poll();
            for(int i=0; i<4; i++) {
                int a = p.a+dir[0][i], b = p.b+dir[1][i];
                if(a>=0 && a<board.length && b>=0 && b<board[0].length) {
                    if(board[a][b]=='O' && !visited[a][b]) {
                        visited[a][b]=true;
                        board[a][b]='-';
                        q.add(new Point(a, b));
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='-') board[i][j]='O';
            }
        }

    }
}
