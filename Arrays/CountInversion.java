package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CountInversion {

    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        long N = 5;
        System.out.println(inversionCount(arr, N));
    }

    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return breakArr(arr, 0l, N-1);
    }

    static long breakArr(long arr[], long start, long end) {
        int count = 0;
        if(start < end) {
            long mid = start + (end-start)/2;
            count+=breakArr(arr, start, mid);
            count+=breakArr(arr, mid+1, end);
            count+=merge(arr, start, mid, end);
        }
        return count;
    }
/*
    {2, 4, 1, 3, 5}
     0  1  2  3  4
     s     m     e

    {2, 4, 1} {3, 5}
     0  1  2   3  4
     s  m  e   s  e
               m

    {2, 4} {1} {3} {5}
     0  1   2   3   4
     s  e   s   s   s
     m      e   e   e
            m   m   m

    {2} {4}
     0   1
     s   s
     e   e
     m   m
*/
    static long merge(long arr[], long start, long mid, long end) {
        long count = 0;
        List<Long> list = new ArrayList<>();
        int i = (int) start;
        int j = (int) mid+1;
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                count+=(mid-i+1);
                list.add(arr[j]);
                j++;
            }
        }
        while(i <= mid) {
            list.add(arr[i]);
            i++;
        }
        while(j <= end) {
            list.add(arr[j]);
            j++;
        }
        int k = (int) start;
        for(long num: list) {
            arr[k++] = num;
        }
        return count;
    }
}
