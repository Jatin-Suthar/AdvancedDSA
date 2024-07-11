package BinarySearch;

public class MedianInRowWiseSortedArray {

    int median(int matrix[][], int n, int m) {
        int e = Integer.MIN_VALUE, s = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                e = Math.max(e, matrix[i][j]);
                s = Math.min(s, matrix[i][j]);
            }
        }
        while(s<=e) {
            int mid = (s+e)/2;
            int count = countSmallerOrEqual(matrix, mid, n, m);
            if(count<=(m*n)/2) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return s;
    }
    public int countSmallerOrEqual(int[][] matrix, int mid, int n, int m) {
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                count += ((matrix[i][j]<=mid) ? 1 : 0);
            }
        }
        //here you can find upperBound using binary search also
        return count;
    }

}
