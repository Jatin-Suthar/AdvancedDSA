package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoBestNonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] events = {
                {1,5,2},
                {1,5,3},
                {6,6,2}
        };
        TwoBestNonOverlappingIntervalSolution solution = new TwoBestNonOverlappingIntervalSolution();
        System.out.println(solution.maxTwoEvents(events));
    }

}

class TwoBestNonOverlappingIntervalSolution {
    Map<String, Integer> map = new HashMap<>();
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[2], Comparator.reverseOrder()));
        return dfs(events, 0, 0, 0);
    }
    public int dfs(int[][] events, int idx, int count, int prev) {
        if (idx == events.length) { return 0; }
        String key = idx + " " + count + " " + prev;
        if(map.containsKey(key)) { return map.get(key); }
        int sum = 0;
        if(count<2) {
            if(prev<events[idx][0]) {
                sum = Math.max(sum, events[idx][2] + dfs(events, idx+1, count+1, events[idx][1]));
            }
            sum = Math.max(sum, dfs(events, idx+1, count, prev));
        }
        map.put(key, sum);
        return sum;
    }
}
/*
6 -> 13

[1,3,5],[1,3,2],[4,5,6]
[1,4,5],[2,3,2],[4,5,6]
[1,2,3],[2,4,6],[3,5,2]
[1,2,3],[2,4,6],[3,5,4]

[1,3,2] [2,4,3] [4,5,2]

[1,5,2] [1,5,3] [6,6]


max(from all) -> -> -> -> sum of all
condition ->
*/