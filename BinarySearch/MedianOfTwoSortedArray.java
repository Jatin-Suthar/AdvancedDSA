package BinarySearch;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {7,8,9,10};
        int[] nums2 = {1,2,4,5,6,11};
        MedianOfTwoSortedArraySolution solution = new MedianOfTwoSortedArraySolution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

}

class MedianOfTwoSortedArraySolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n<m) {
            return binarySearch(nums1, nums2, n, m);
        } else {
            return binarySearch(nums2, nums1, m, n);
        }
    }
    public double binarySearch(int[] nums1, int[] nums2, int n, int m) {
        int st = 0, ed = n, len = n+m;
        int required = (len+1)/2;
        while(st<=ed) {
            int mid1 = (st + ed) >> 1;
            int mid2 = required - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];
            if(mid1 < n) r1 = nums1[mid1];
            if(mid2 < m) r2 = nums2[mid2];
            if(l1 <= r2 && l2 <= r1) {
                if(len%2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2)))/2.0;
                }
            } else if(l1 > r2) ed = mid1-1;
            else if(l2 > r1) st = mid1+1;
        }
        return 0;
    }
}

/*
 0 1 2 3
[7,8,9,10]
[1,2,4,5,6,11]

          | 7 8 9 10
1 2 4 5 6 | 11

0 1 2 3 4 | 5 6 7 8  9
1 2 4 5 6 | 7 8 9 10 11

*/
