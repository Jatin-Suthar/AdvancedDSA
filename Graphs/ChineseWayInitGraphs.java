package Graphs;

import java.util.*;
import System.FastReader;

public class ChineseWayInitGraphs {
    // 1. Define maximum sizes (adjust as needed)
    static final int MAXN = 100_000;   // max number of vertices
    static final int MAXM = 200_000;   // max number of edges (×2 for undirected)

    /** head[u] points to the first edge index out of u; –1 means “none” */
    static int[] head = new int[MAXN + 1];

    /** to[i], w[i]: destination and weight of the i-th edge */
    static int[] to   = new int[MAXM + 1];
    static int[] w    = new int[MAXM + 1];

    /** next[i]: index of the next edge out of the same source as edge i */
    static int[] next = new int[MAXM + 1];

    static int edgeCnt = 0;

    // 2. Call this before building any graph:
    static void initGraph(int n) {
        Arrays.fill(head, 1, n + 1, -1);
        edgeCnt = 0;
    }

    // 3. Add a directed edge u → v with weight wt
    static void addEdge(int u, int v, int wt) {
        to[edgeCnt]   = v;
        w[edgeCnt]    = wt;
        next[edgeCnt] = head[u];
        head[u]       = edgeCnt++;
    }

    // 4. If it’s undirected, just call addEdge twice:
    static void addUndirected(int u, int v, int wt) {
        addEdge(u, v, wt);
        addEdge(v, u, wt);
    }

    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        int n = in.nextInt(), m = in.nextInt();
        initGraph(n);

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int wt = in.nextInt();
            addEdge(u, v, wt);
        }

        // 5. kick off your searches
        dfs(1);
        bfs();
    }

    // 6. DEPTH-FIRST SEARCH
    static boolean[] visited = new boolean[MAXN + 1];
    static void dfs(int u) {
        visited[u] = true;
        // process u here
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    // 7. BREADTH-FIRST SEARCH
    static void bfs() {
        Arrays.fill(visited, 1, visited.length, false);
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int u = q.poll();
            // process u here
            for (int i = head[u]; i != -1; i = next[i]) {
                int v = to[i];
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
