package Graphs;

import java.io.IOException;
import java.util.*;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution_ShortestPathInUndirectedGraph obj = new Solution_ShortestPathInUndirectedGraph();
            int[] res = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }

}

class Solution_ShortestPathInUndirectedGraph {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[] distance = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
        }
        for(int[] edge: edges) {
            int v = edge[0];
            int u = edge[1];
            list.get(v).add(u);
        }
        distance[src]=0;
        boolean[] visited = new boolean[n];
        dfs(list, src, visited, distance);
        for(int i=0; i<n; i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                distance[i]=-1;
            }
        }
        return distance;
    }
    public void dfs(List<List<Integer>> adj, int src, boolean[] visited, int[] distance) {
        visited[src] = true;
        for(int idx: adj.get(src)) {
            if(distance[src]!=Integer.MAX_VALUE) {
                if(!visited[idx]) {
                    if(distance[src]+1<distance[idx]) {
                        distance[idx]=distance[src]+1;
                    }
                    dfs(adj, idx, visited, distance);
                }
            }
        }
    }
}