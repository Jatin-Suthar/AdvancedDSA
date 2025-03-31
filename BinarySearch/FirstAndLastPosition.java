package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FirstAndLastPositionSolution solution = new FirstAndLastPositionSolution();
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }

}

class FirstAndLastPositionSolution {
    public int[] searchRange(int[] nums, int target) {
        int st = floor(nums, target), n = nums.length;
        if(n == 0 || st>=n || nums[st]!=target) {
            return new int[] {-1, -1};
        }
        int ed = ceil(nums, target);
        if(ed >= n || nums[ed]!=target) {
            return new int[] {st, st};
        }
        return new int[] {st, ed};
    }

    /*

    arr = {5,7,7,8,8,10}, x = 8
            e s
    0 1 2 3 4 5
    5 7 7 8 8 10

    mid = 4

     */

    public int ceil(int[] nums, int target) {
        int st = 0, ed = nums.length-1;
        while(st<=ed) {
            int mid = st + (ed-st)/2;
            if(nums[mid] > target) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return ed;
    }
    public int floor(int[] nums, int target) {
        int st = 0, ed = nums.length-1;
        while(st<=ed) {
            int mid = st + (ed-st)/2;
            if(nums[mid] >= target) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return st;
    }
}