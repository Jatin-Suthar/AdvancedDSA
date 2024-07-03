package matrix;

public class SearchInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int midPos = matrix[0].length/2;
        int start = 0;
        int end = n-1;
        while(start<end-1) {
            int mid = (start+end)/2;
            if(matrix[mid][midPos]==target) {
                return true;
            } else if(matrix[mid][midPos] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(binarySearch(matrix, target, start)) { return true; }
        return binarySearch(matrix, target, end);
    }
    public boolean binarySearch(int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(matrix[row][mid]==target) {
                return true;
            } else if(matrix[row][mid]<target) {
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return false;
    }

}
