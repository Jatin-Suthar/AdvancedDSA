package matrix;

import java.util.*;

public class CountCoveredBuildings {
    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        CountCoveredBuildingsSolution solution = new CountCoveredBuildingsSolution();
        System.out.println(solution.countCoveredBuildings(n, buildings));
    }
}

class CountCoveredBuildingsSolution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        Map<Integer, Pair> row = new HashMap<>();
        Map<Integer, Pair> col = new HashMap<>();

        for (int[] building : buildings) {
            int x = building[0], y = building[1];

            row.computeIfAbsent(x, k -> new Pair(y, y));
            col.computeIfAbsent(y, k -> new Pair(x, x));

            Pair rowPair = row.get(x);
            rowPair.min = Math.min(rowPair.min, y);
            rowPair.max = Math.max(rowPair.max, y);

            Pair colPair = col.get(y);
            colPair.min = Math.min(colPair.min, x);
            colPair.max = Math.max(colPair.max, x);
        }

        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            Pair rowPair = row.get(x);
            Pair colPair = col.get(y);

            if (rowPair.min < y && rowPair.max > y &&
                    colPair.min < x && colPair.max > x) {
                ans++;
            }
        }

        return ans;
    }

    static class Pair {
        int min, max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
