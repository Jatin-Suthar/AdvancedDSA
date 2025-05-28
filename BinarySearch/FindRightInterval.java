package BinarySearch;

import java.util.*;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3},{3,4}};
        FindRightIntervalSolution solution = new FindRightIntervalSolution();
        System.out.println(Arrays.toString(solution.findRightInterval(intervals)));
    }
}

class FindRightIntervalSolution {
    public int[] findRightInterval(int[][] intervals) {
        int n;
        int[][] copy = new int[n = intervals.length][3];
        for (int i = 0; i < n; i++) {
            copy[i][0] = intervals[i][0];
            copy[i][1] = intervals[i][1];
            copy[i][2] = i;
        }
        Arrays.sort(copy, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
        int[] ans = new int[n];
        int k = 0;
        for(int[] arr: intervals) {
            int idx = searchIdx(copy, arr[1], 0, n-1);
            ans[k++] = idx;
        }
        return ans;
    }
    public int searchIdx(int[][] intervals, int target, int st, int ed) {
        int ans = -1;
        while(st<=ed) {
            int mid = (st+ed) >> 1;
            if(intervals[mid][0] >= target) {
                ans = intervals[mid][2];
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return ans;
    }
}

/*

[[1,4],[2,3],[3,4]]
[[1,4],[2,3],[3,4]]


*/