package Graphs.ShortestPaths;

import java.util.*;

public class ShortestSourceToDestinationPath {
    static class Solution {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int shortestDistance(int N, int M, int A[][], int X, int Y) {
            if(A[0][0] == 0 || A[X][Y] == 0) return -1;
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p -> p.d));
            int[][] dist = new int[N][M];
            for(int[] arr: dist) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            dist[0][0] = 0;
            pq.add(new Pair(0, 0, 0));
            while(!pq.isEmpty()) {
                Pair p = pq.poll();
                int i = p.x;
                int j = p.y;
                int d = p.d;
                if(d > dist[i][j] || A[i][j] == 0) continue;
                for(int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && y >= 0 && x < N && y < M && A[x][y] == 1 && d + 1 < dist[x][y]) {
                        dist[x][y] = d + 1;
                        pq.add(new Pair(x, y, dist[x][y]));
                    }
                }
            }
            return (dist[X][Y] == Integer.MAX_VALUE) ? -1 : dist[X][Y];
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
    };
}
