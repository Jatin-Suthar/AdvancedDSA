package BinarySearch;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinInRotatedSortedArraySolution solution = new FindMinInRotatedSortedArraySolution();
        int[] nums = {2,3,4,5,6,7,8,9,1};
        System.out.println(solution.findMin(nums));
    }
}

class FindMinInRotatedSortedArraySolution {
    public int findMin(int[] nums) {
        int min = findMin(nums, 0, nums.length-1);
        if(min == -1) {
            return nums[0];
        }
        return min;
    }
    public int findMin(int[] nums, int st, int ed) {
        while(st<=ed) {
            int mid = (st+ed) >> 1;
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(nums[st] < nums[ed]) {
                return nums[st];
            } else if(nums[st] <= nums[mid]) {
                st = mid+1;
            } else {
                ed = mid-1;
            }
        }
        return -1;
    }
}
/*
 0 1 2 3 4
[3,4,5,1,2]
 s       e
*/