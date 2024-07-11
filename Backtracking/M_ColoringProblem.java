package Backtracking;

public class M_ColoringProblem {

    public boolean graphColoring(boolean graph[][], int m, int n) {
        return color(graph, m, n, new int[n], 0);
    }
    public boolean color(boolean[][] graph, int m, int n, int[] colors, int node) {
        if(node==n) return true;
        for(int i=1; i<=m; i++) {
            if(isSafe(graph, n, colors, i, node)) {
                colors[node]=i;
                if(color(graph, m, n, colors, node+1)) {
                    return true;
                }
                colors[node]=0;
            }
        }
        return false;
    }
    public boolean isSafe(boolean[][] graph, int n, int[] colors, int color, int node) {
        for(int i=0; i<n; i++) {
            if(graph[node][i] && colors[i]==color) return false;
        }
        return true;
    }

}
