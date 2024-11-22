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
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patFreq = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }

        return Collections.max(patFreq.values());
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
