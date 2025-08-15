package SlidingWindow;

import java.util.*;

public class ReschedulingMeetingToGetMaximumFreeTimeI {
    public static void main(String[] args) {
        System.out.println(new Solution().maxFreeTime(30, 2,
                                                      new int[] {1,15,17}, new int[] {14,17,29}));
    }
    static class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            int n = startTime.length;
            int st = 0, ed = 0, free = 0, right = 0, maxGap = 0;
            while(ed < k) {
                free += ((ed==0) ? startTime[0] : startTime[ed] - endTime[ed-1]);
                ed++;
            }
            right = (ed == n) ? eventTime - endTime[n-1] : startTime[ed] - endTime[ed-1];
            maxGap = Math.max(maxGap, free + right);
            while(ed < n) {
                int l = ((st == 0) ? startTime[0] : startTime[st] - endTime[st-1]);
                free -= l;
                st++;
                int r = ((ed == 0) ? startTime[0] : startTime[ed] - endTime[ed-1]);
                free += r;
                ed++;
                right = ((ed == n) ? eventTime - endTime[n-1] : startTime[ed] - endTime[ed-1]);
                maxGap = Math.max(maxGap, free + right);
            }
            return maxGap;
        }
    }
}
