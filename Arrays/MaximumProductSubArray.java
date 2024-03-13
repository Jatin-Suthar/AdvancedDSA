package Arrays;

public class MaximumProductSubArray {
    long maxProduct(int[] arr, int n) {
        long max = arr[0];
        long min = arr[0];
        long ans = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i]<0) {
                long temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min*arr[i], arr[i]);
            max = Math.max(max*arr[i], arr[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
