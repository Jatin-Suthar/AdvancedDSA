package BinarySearch;

import java.util.Arrays;

public class FindFloorAndCeil {

    public static void main(String[] args) {
        int x = 17;
        int arr[] = {36, 82, 88, 56, 21, 17, 73, 17};
        FindFloorAndCeilSolution solution = new FindFloorAndCeilSolution();
        System.out.println(Arrays.toString(solution.getFloorAndCeil(x, arr)));
    }

}

class FindFloorAndCeilSolution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int floor = -1, ceil = -1;
        int st = 0, ed = arr.length -1;
        while(st<=ed) {
            int mid = st + (ed-st)/2;
            if(arr[mid] == x) {
                return new int[] {x, x};
            }
            if(arr[mid] > x) {
                ceil = mid;
                ed = mid-1;
            } else {
                floor = mid;
                st = mid+1;
            }
        }
        return new int[] {(floor==-1)?-1:arr[floor],
                (ceil==-1)?-1:arr[ceil]};
    }
}