package Arrays;

public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int idx = getIdx(matrix, target, 0, matrix.length-1);
        if(matrix[idx][0]==target) return true;
        boolean first = binarySearch(matrix, target, idx);
        if(!first) {
            return binarySearch(matrix, target, idx-1);
        } else {
            return true;
        }
    }

    public static boolean binarySearch(int[][] matrix, int target, int idx) {
        int start = 0;
        int end = matrix[0].length;
        while(start<end) {
            int mid = (start+end)/2;
            if(matrix[idx][mid]==target) return true;
            else if(matrix[idx][mid]<target) start = mid+1;
            else end = mid;
        }
        return false;
    }

    public static int getIdx(int[][] matrix, int target, int start, int end) {
        if(start<end) {
            int mid = (start+end)/2;
            if(target==matrix[mid][0]) {
                return mid;
            } else if(target < matrix[mid][0]) {
                return getIdx(matrix, target, start, mid);
            } else {
                return getIdx(matrix, target, mid+1, end);
            }
        }
        return start;
    }
}
