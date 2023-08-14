package BinarySearch;

public class NthRoot {

    public static void main(String[] args) {
        int n = 6;
        int m = 4096;
        System.out.println(NthRoot(n, m));
    }

    public static int NthRoot(int n, int m)
    {
        if(n==1 || m==1) return m;
        int start = 2;
        int end = m/2;

        while(start<=end) {
            int mid = start+(end-start)/2;
            double val = Math.pow(mid, n);
            if(val==(double) m) return mid;
            else if(val < m) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
