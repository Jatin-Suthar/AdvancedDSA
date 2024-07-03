package Arrays;

import java.util.Arrays;

public class CountInversionOfArray {

    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }

    static long inversionCount(long arr[], int n) {
        long ans = divide(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        return ans;
    }
    static long divide(long arr[], int left, int right) {
        long count = 0;
        if(left<right) {
            int mid = (right+left)/2;
            count += divide(arr, left, mid);
            count += divide(arr, mid+1, right);
            count += merge(arr, left, right, mid);
        }
        return count;
    }
    static long merge(long arr[], int left, int right, int mid) {
        int i=left;
        int j=mid+1;
        int k=0;
        long count = 0;
        long[] modArr = new long[right-left+1];
        while(i<=mid && j<=right) {
            if(arr[i]>arr[j]) {
                count += (mid-i+1);
                modArr[k++]=arr[j++];
            } else {
                modArr[k++]=arr[i++];
            }
        }
        while(i<=mid) {
            modArr[k++]=arr[i++];
        }
        while(j<=right) {
            modArr[k++]=arr[j++];
        }
        i = left;
        for(long num: modArr) {
            arr[i++] = num;
        }
        return count;
    }

}
