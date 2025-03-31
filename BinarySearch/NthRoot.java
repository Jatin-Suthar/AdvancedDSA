package BinarySearch;

public class NthRoot {
    public static int findNthRoot(int n, int m) {
        int st = 1, ed = m/2;
        while(st <= ed) {
            int mid = st + (ed-st)/2;
            double nth = Math.pow(mid, n);
            if(nth == m) {
                return mid;
            } else if(nth > m) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return -1;
    }
}
