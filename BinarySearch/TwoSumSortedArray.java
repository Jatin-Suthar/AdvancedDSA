package BinarySearch;

import java.util.*;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] nums = {-10,-8,-2,1,2,5,6};
        int target = 0;
        TwoSumSortedArraySolution solution = new TwoSumSortedArraySolution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}

class TwoSumSortedArraySolution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length-1; i++) {
            if(numbers[i]+numbers[i+1] == target) {
                return new int[] {i+1, i+2};
            } else {
                int idx = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
                if(idx!=-1) {
                    return new int[]{i + 1, idx + 1};
                }
            }
        }
        return new int[0];
    }
    public int binarySearch(int[] nums, int st, int ed, int target) {
        while(st<=ed) {
            int mid = (st+ed) >> 1;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) st = mid+1;
            else ed = mid-1;
        }
        return -1;
    }
}