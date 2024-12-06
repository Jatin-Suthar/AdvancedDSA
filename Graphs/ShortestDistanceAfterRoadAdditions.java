package Graphs;

import java.util.*;

public class ShortestDistanceAfterRoadAdditions {

    public static void main(String[] args) {
        int n = 5; int[][] queries = {{2,4},{0,2},{0,4}};
        ShortestDistanceAfterRoadAdditionsSolution solution = new ShortestDistanceAfterRoadAdditionsSolution();
        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n, queries)));
    }

}

class ShortestDistanceAfterRoadAdditionsSolution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n-1; i++) {
            list.add(new ArrayList<>(List.of(i + 1)));
        }
        list.add(new ArrayList<>());
        int[] res = new int[queries.length];
        int k = 0;
        for(int[] query: queries) {
            list.get(query[0]).add(query[1]);
            int[] dist = shortestPath(list, n);
            res[k++] = dist[n-1];
        }
        return res;
    }

    public int[] shortestPath(List<List<Integer>> adjList, int n) {
        Queue<QueuePair> queue = new PriorityQueue<>(Comparator.comparingInt((QueuePair a) -> a.dist));
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0]=0;
        queue.add(new QueuePair(0, 0));
        while(!queue.isEmpty()) {
            QueuePair p = queue.poll();
            int vert = p.vert;
            int dist = p.dist;
            for(int neighbour: adjList.get(vert)) {
                if(dis[neighbour]>dist+1) {
                    dis[neighbour] = dist+1;
                    queue.add(new QueuePair(dis[neighbour], neighbour));
                }
            }
        }
        return dis;
    }
}

class QueuePair {
    int dist;
    int vert;
    public QueuePair(int dist, int vert) {
        this.dist = dist;
        this.vert = vert;
    }
}