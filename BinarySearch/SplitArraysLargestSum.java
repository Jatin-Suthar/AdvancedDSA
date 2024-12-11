package BinarySearch;

public class SplitArraysLargestSum {
}

class SplitArraysLargestSumSolution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int num: nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low<high) {
            int mid = (low+high)/2;
            if(countAllocation(nums, mid, k)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
    public boolean countAllocation(int[] nums, int target, int k) {
        int allocation = 1, piecesCount = 0;
        for(int num: nums) {
            piecesCount+=num;
            if(piecesCount>target) {
                piecesCount=num;
                allocation++;
            }
            if(allocation>k) return false;
        }
        return true;
    }
}