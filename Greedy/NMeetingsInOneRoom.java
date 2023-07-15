package Greedy;

import java.util.*;

public class NMeetingsInOneRoom {
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<start.length; i++) {
            list.add(new int[]{start[i], end[i]});
        }

        //now sort this
        Comparator<int[]> customComparator = Comparator
                .comparingInt((int[] arr) -> arr[1])
                .thenComparingInt(arr -> arr[0]);

        list.sort(customComparator);

        int count = 1, endTime = list.get(0)[1];
        for(int i=1; i<list.size(); i++) {
            if(endTime<list.get(i)[0]) {
                endTime = list.get(i)[1];
                count++;
            }
        }
        return count;
    }
}
