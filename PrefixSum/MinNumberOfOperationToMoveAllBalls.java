package PrefixSum;

import java.util.Arrays;

public class MinNumberOfOperationToMoveAllBalls {
    public static void main(String[] args) {
        String boxes = "110";
        MinNumberOfOperationToMoveAllBallsSolution solution = new MinNumberOfOperationToMoveAllBallsSolution();
        System.out.println(Arrays.toString(solution.minOperations(boxes)));
    }
}

class MinNumberOfOperationToMoveAllBallsSolution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        calculateDistance(boxes, ans, true);
        calculateDistance(boxes, ans, false);
        return ans;
    }

    private void calculateDistance(String boxes, int[] ans, boolean leftToRight) {
        int balls = 0, distance = 0, n = boxes.length();
        int start = leftToRight ? 0 : n - 1;
        int end = leftToRight ? n : -1;
        int step = leftToRight ? 1 : -1;

        for (int i = start; i != end; i += step) {
            ans[i] += distance;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            distance += balls;
        }
    }
}