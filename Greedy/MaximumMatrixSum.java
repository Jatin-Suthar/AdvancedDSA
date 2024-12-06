package Greedy;

public class MaximumMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = {{-9,9,9,-9},{-10,10,7,5},{4,-8,-9,6},{10,2,-6,1}};
        MaximumMatrixSumSolution solution = new MaximumMatrixSumSolution();
        System.out.println(solution.maxMatrixSum(matrix));
    }

}

class MaximumMatrixSumSolution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negatives = 0;
        int smallest = Integer.MAX_VALUE;
        for(int[] row: matrix) {
            for (int num : row) {
                if (num < 0) negatives++;
                int abs = Math.abs((-1) * num);
                smallest = Math.min(smallest, abs);
                sum += abs;
            }
        }
        return (negatives%2!=0) ? sum-(2L*smallest) : sum;
    }
}
/*
 1 -1 -3 -6
-1  1  1  1
 1  1  1  1
 3  3  2 -1

 1  0

11 -> 00,01,02,10,12,20,21,22
*/