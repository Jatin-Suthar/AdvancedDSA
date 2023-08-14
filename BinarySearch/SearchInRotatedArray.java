package BinarySearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int nums[] = {1,3,5};
        int target = 5;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }

}

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int pivot = findPivot(nums, start, end);
        System.out.println(pivot);
        if (nums[pivot] == target) return pivot;
        int left = binarySearch(nums, target, start, pivot - 1);
        if (left != -1) {
            return left;
        }
        return binarySearch(nums, target, pivot + 1, end);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums, int start, int end) {
        if (start == end) return start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}