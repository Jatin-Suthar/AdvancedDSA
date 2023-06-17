package Arrays;

import java.util.*;

public class InversionArray {

    public static void main(String[] args) {
        long[] arr = {2,5,1,3,4};
        System.out.println(getInversions(arr, arr.length));
    }

    public static long getInversions(long arr[], int n) {
        return doPartition(arr, 0, n-1);
    }

    private static long doPartition(long[] arr, int start, int end) {
        long count = 0;
        if(start<end) {
            int mid = start + (end-start)/2;
            count += doPartition(arr, start, mid);
            count += doPartition(arr, mid+1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    private static long merge(long[] arr, int start, int mid, int end) {
        List<Long> temp = new ArrayList<>();
        int i = start;
        int j = mid+1;
        long count = 0;
        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                count += (mid-i+1);
                j++;
            }
        }
        while(i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while(j<=end) {
            temp.add(arr[j]);
            j++;
        }
        int k=0;
        for(int idx = start; idx <= end; idx++) {
            arr[idx] = temp.get(k++);
        }
        return count;
    }
}
