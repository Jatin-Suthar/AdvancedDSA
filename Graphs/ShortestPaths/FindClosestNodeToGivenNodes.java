package Graphs.ShortestPaths;

import java.util.*;

public class FindClosestNodeToGivenNodes {
    public static void main(String[] args) {
        int[] edges = {4,4,8,-1,9,8,4,4,1,1};
        int node1 = 5, node2 = 6;
        System.out.println(new Solution().closestMeetingNode(edges, node1, node2));
    }
    static class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            int[] dist1 = findShortestPath(edges, node1, n);
            int[] dist2 = findShortestPath(edges, node2, n);
            int minDist = Integer.MAX_VALUE, minPos = -1;
            for(int i=0; i<n; i++) {
                if(dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) continue;
                int sumDist = Math.max(dist1[i], dist2[i]);
                if(minDist > sumDist) {
                    minDist = sumDist;
                    minPos = i;
                }
            }
            return minPos;
        }
        public int[] findShortestPath(int[] edges, int source, int n) {
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.dist));
            queue.add(new Node(source, 0));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                int u = node.source;
                int d = node.dist;
                if(d > dist[u]) {
                    continue;
                }
                int neighbour = edges[u];
                if(neighbour == -1) continue;
                if(dist[u]+1 < dist[neighbour]) {
                    dist[neighbour] = dist[u]+1;
                    queue.add(new Node(neighbour, dist[neighbour]));
                }
            }
            return dist;
        }
        static class Node {
            int source;
            int dist;
            public Node(int source, int dist) {
                this.source = source;
                this.dist = dist;
            }
        }
    }
}

/*
0 1 2  3 4 5 6 7 8 9
4,4,8,-1,9,8,4,4,1,1

 */