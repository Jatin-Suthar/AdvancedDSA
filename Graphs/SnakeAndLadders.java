package Graphs;

import java.util.*;

public class SnakeAndLadders {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,35,-1,-1,13,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,15,-1,-1,-1,-1}};
        System.out.println(new Solution().snakesAndLadders(board));
    }
    static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            int[][] state = new int[n+1][n+1];
            for(int[] s: state) {
                Arrays.fill(s, Integer.MAX_VALUE);
            }
            state[n][1] = 0;
            boolean[][] visited = new boolean[n+1][n+1];
            PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(p -> p.d));
            q.add(new Pair(n, 1, 0));
            while(!q.isEmpty()) {
                Pair p = q.poll();
                int x = p.x, y = p.y;
                int dist = p.d;
                visited[x][y] = true;
                if(dist > state[x][y]) continue;
                for(int i=1; i<=6; i++) {
                    int[] idx = getIndices(board, n, visited, x, y, i);
                    int r = idx[0], c = idx[1];
                    if(r == -1) continue;
                    if(dist+1 < state[r][c]) {
                        state[r][c] = dist+1;
                        q.add(new Pair(r, c, state[r][c]));
                    }
                }
            }
            return state[1][1];
        }
        public int[] getIndices(int[][] board, int n, boolean[][] visited, int x, int y, int i) {
            int r = x, c;
            if((x & 1) != 1) {
                if (y + i > n) {
                    r -= 1;
                    c = (i + y) - n;
                } else {
                    c = y + i;
                }
            } else {
                if (y - i < 1) {
                    r -= 1;
                    c = 1 + (i - y);
                } else {
                    c = y - i;
                }
            }
            if(r-1 < 0) return new int[] {-1, -1};
            int s = board[r - 1][c - 1];
            if (!visited[r][c] && s != -1) {
                int rowFromBottom = (s - 1) / n;
                r = (n - 1) - rowFromBottom;

                int offsetInRow = (s - 1) % n;
                boolean leftToRight = (rowFromBottom % 2 == 0);

                if (leftToRight) {
                    c = offsetInRow;
                } else {
                    c = (n - 1) - offsetInRow;
                }
                r += 1;
                c += 1;
            }
            return new int[] {r, c};
        }
        static class Pair {
            int x;
            int y;
            int d;
            public Pair(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.d = d;
            }
        }
    }
}