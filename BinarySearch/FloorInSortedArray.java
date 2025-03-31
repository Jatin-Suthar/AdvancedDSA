package BinarySearch;

public class FloorInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 11;
        System.out.println(findFloor(arr, x));
    }

    static int findFloor(int[] arr, int x) {
        int n = arr.length;
        int st = 0, ed = n-1;
        int ans = -1;
        while(st<=ed) {
            int mid = st + (ed-st)/2;
            if(arr[mid]>x) {
                ed = mid-1;
            } else {
                ans = mid;
                st = mid+1;
            }
        }
        return ans;
    }

}
