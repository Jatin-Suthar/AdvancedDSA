package Graphs;

public class SurroundedRegionsDFS {

}

class Solution_SurroundedRegionsDFS {
    int[] ver = {-1, 0, 1, 0};
    int[] hor = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int j=0; j<m; j++) {
            //jth iteration
            if(!visited[0][j] && board[0][j]=='O') {
                dfs(board, visited, 0, j);
            }
        }
        for(int i=1; i<n; i++) {
            //ith iteration
            if(!visited[i][m-1] && board[i][m-1]=='O') {
                dfs(board, visited, i, m-1);
            }
        }
        for(int j=m-1; j>=0; j--) {
            //jth iteration
            if(!visited[n-1][j] && board[n-1][j]=='O') {
                dfs(board, visited, n-1, j);
            }
        }
        for(int i=n-1; i>=1; i--) {
            //ith iteration
            if(!visited[i][0] && board[i][0]=='O') {
                dfs(board, visited, i, 0);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                } else if(board[i][j]=='S') {
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j]=true;
        grid[i][j]='S';
        for(int idx=0; idx<4; idx++) {
            int ith = i+ver[idx];
            int jth = j+hor[idx];
            if(ith<0 || ith>=grid.length || jth<0 || jth>=grid[0].length) {
                continue;
            }
            if(!visited[ith][jth] && grid[ith][jth]=='O') {
                dfs(grid, visited, ith, jth);
            }
        }
    }
}
