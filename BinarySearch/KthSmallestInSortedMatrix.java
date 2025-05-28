package BinarySearch;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{ 1, 5, 8},
                          {10,11,13},
                          {12,13,14}};
        KthSmallestInSortedMatrixSolution solution = new KthSmallestInSortedMatrixSolution();
        System.out.println(solution.kthSmallest(matrix, 3));
    }
}

class KthSmallestInSortedMatrixSolution {
    public int kthSmallest(int[][] matrix, int k) {
        int n, st = matrix[0][0], ed = matrix[(n = matrix.length)-1][n-1];

        while(st<ed) {
            int mid = (st+ed)>>1;
            int count = countLessOrEqual(matrix, n, mid);
            if(k > count) {
                st = mid+1;
            } else {
                ed = mid;
            }
        }
        return st;
    }

    private int countLessOrEqual(int[][] matrix, int n, int mid) {
        int row = n-1, col = 0, count = 0;
        while(row>=0 && col<n) {
            if(matrix[row][col] <= mid) {
                count += (row+1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}

/*

[
    [ 1,  5,  9],
    [10, 11, 13],
    [12, 13, 15]
]


*/