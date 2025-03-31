package BinarySearch;

public class MedianOfSortedMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        MedianOfSortedMatrixSolution solution = new MedianOfSortedMatrixSolution();
        System.out.println(solution.median(mat));
    }

}


class MedianOfSortedMatrixSolution {
    int median(int[][] mat) {
        int st = Integer.MAX_VALUE, ed = Integer.MIN_VALUE;
        int n = mat.length, m = mat[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                st = Math.min(st, mat[i][j]);
                ed = Math.max(ed, mat[i][j]);
            }
        }

        while(st<=ed) {
            int mid = st + (ed-st)/2;
            int count = countLessOrEqualNum(mat, mid, n, m);
            if(count <= (n*m)/2) {
                st = mid+1;
            } else {
                ed = mid-1;
            }
        }
        return st;
    }


    int countLessOrEqualNum(int[][] nums, int target, int n, int m) {
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(nums[i][j] <= target) {
                    count++;
                }
            }
        }
        return count;
    }

}