package Graphs.ShortestPaths;

public class FloydWarshallAlgorithm {
    static void floydWarshall(int[][] dist){
        int V = dist.length;

        // Add all vertices one by one to
        // the set of intermediate vertices.
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++) {

                    // shortest path from
                    // i to j
                    if(dist[i][k] != 1e8 && dist[k][j]!= 1e8)
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int INF = 100000000;

        int[][] dist = { { 0, 4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 } };

        floydWarshall(dist);
        for (int[] d : dist) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(d[j] + " ");
            }
            System.out.println();
        }
    }
}
