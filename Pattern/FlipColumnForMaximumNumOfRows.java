package Pattern;

import java.util.*;

public class FlipColumnForMaximumNumOfRows {

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,0,0,0,1,1,1,0,1,1,1},
                            {1,0,0,0,1,0,0,0,1,0,0},
                            {1,0,0,0,1,1,1,0,1,1,1},
                            {1,0,0,0,1,0,0,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,1,1}
                        };
        FlipColumnForMaximumNumOfRowsSolution solution = new FlipColumnForMaximumNumOfRowsSolution();
        System.out.println(solution.maxEqualRowsAfterFlips(matrix));
    }

}

class FlipColumnForMaximumNumOfRowsSolution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        int i=0;
        while (i<n) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j=0; j<m; j++) {
                sb1.append((matrix[i][j]==0) ? "*" : "|");
                sb2.append((matrix[i][j]==0) ? "|" : "*");
            }
            String firstPattern = sb1.toString();
            String secondPattern = sb2.toString();
            map.put(firstPattern, map.getOrDefault(firstPattern, 0)+1);
            map.put(secondPattern, map.getOrDefault(secondPattern, 0)+1);
            ans = Math.max(ans, Math.max(map.get(firstPattern), map.get(secondPattern)));
            i++;
        }
        return ans;
    }
}
/*
[
    [1,0,0,0,1,1,1,0,1,1,1],
    [1,0,0,0,1,0,0,0,1,0,0],
    [1,0,0,0,1,1,1,0,1,1,1],
    [1,0,0,0,1,0,0,0,1,0,0],
    [1,1,1,0,1,1,1,0,1,1,1]
]

[
    [0,0,0], -> 0
    [0,0,1], -> 1
    [1,1,0]  ->
]

**|
||*
*/
