package PrefixSum;

public class XorQueryOfSubarray {
}

class XorQueryOfSubarraySolution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length, pXor = 0;
        int[] xor = new int[n+1];
        for(int i=0; i<n; i++) {
            pXor ^= arr[i];
            xor[i+1] = pXor;
        }
        int[] res = new int[queries.length];
        int k=0;
        for(int[] query: queries) {
            res[k++] = xor[query[1]+1]^xor[query[0]];
        }
        return res;
    }
}