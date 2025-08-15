package Graphs;

import java.util.*;

public class MaximumNumberOfTargetNodesAfterConnectingTwoNodesII {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}}, edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        System.out.println(Arrays.toString(new Solution().maxTargetNodes(edges1, edges2)));
    }
    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
            int max = 0;
            int n = edges1.length+1, m = edges2.length+1;
            List<List<Integer>> adj1 = new ArrayList<>();
            List<List<Integer>> adj2 = new ArrayList<>();
            for(int i=0; i<n; i++) adj1.add(new ArrayList<>());
            for(int i=0; i<m; i++) adj2.add(new ArrayList<>());
            for(int[] edge: edges1) {
                adj1.get(edge[0]).add(edge[1]);
                adj1.get(edge[1]).add(edge[0]);
            }
            for(int[] edge: edges2) {
                adj2.get(edge[0]).add(edge[1]);
                adj2.get(edge[1]).add(edge[0]);
            }
            int[] ans = new int[n];
            ans[0] = bfs(adj1, 0, 0);
            int[] dist = findDist(adj1, 0);
            int odds = bfs(adj2, 0, 1);
            max = Math.max(odds, m-odds);
            for(int i=1; i<n; i++) {
                if((dist[i]&1)==0) {
                    ans[i] = ans[0];
                } else {
                    ans[i] = n-ans[0];
                }
                ans[i] += max;
            }
            ans[0] = max+ans[0];
            return ans;
        }
        public int bfs(List<List<Integer>> adj, int u, int flag) {
            Queue<Pair> q = new LinkedList<>();
            boolean[] visited = new boolean[adj.size()];
            q.add(new Pair(u, 0));
            int parity = 0;
            while(!q.isEmpty()) {
                Pair p = q.poll();
                int count = p.count;
                int node = p.u;
                visited[node] = true;
                if((count & 1) == flag) parity++;
                for(int v: adj.get(node)) {
                    if(!visited[v]) {
                        q.add(new Pair(v, count+1));
                    }
                }
            }
            return parity;
        }
        static class Pair {
            int u;
            int count;
            public Pair(int u, int count) {
                this.u = u;
                this.count = count;
            }
        }
        public int[] findDist(List<List<Integer>> adj, int u) {
            PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparing(p -> p.count));
            int[] dist = new int[adj.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[u] = 0;
            q.add(new Pair(u, 0));
            boolean[] visited = new boolean[adj.size()];
            while(!q.isEmpty()) {
                Pair p = q.poll();
                int v = p.u;
                int d = p.count;
                visited[v] = true;
                if(d>dist[v]) {
                    continue;
                }
                for(int neighbour: adj.get(v)) {
                    if(!visited[neighbour]) {
                        if(d+1 < dist[neighbour]) {
                            dist[neighbour] = d+1;
                            q.add(new Pair(neighbour, dist[neighbour]));
                        }
                    }
                }
            }
            return dist;
        }
    }
}
