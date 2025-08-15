package BitManipulationTricksAndHacks.basicfunctions;

import java.util.*;

public class RangeProductQueriesOfPower {
    public static void main(String[] args) {
        int n = 15;
        int[][] queries = {{0,1},{2,2},{0,3}};
        System.out.println(Arrays.toString(new Solution().productQueries(n, queries)));
    }
    static class Solution {
        int MOD = 1000000007;
        public int[] productQueries(int n, int[][] queries) {
            List<Integer> powerArray = minPowerArray(n);
            System.out.println(powerArray);
            int[] prefix = new int[powerArray.size()+1];
            prefix[0] = 1;
            int product = 1;
            for(int i=0; i<powerArray.size(); i++) {
                product = (product * powerArray.get(i))%MOD;
                prefix[i+1] = product;
            }
            int[] ans = new int[queries.length];
            int k=0;
            for(int[] query: queries) {
                ans[k++] = prefix[query[1]+1]/prefix[query[0]];
            }
            return ans;
        }
        public List<Integer> minPowerArray(int n) {
            List<Integer> res = new ArrayList<>();
            while (n > 0) {
                int p = Integer.lowestOneBit(n);
                res.add(p);
                n -= p;
            }
            return res;
        }
    }

/**

 0 1 2 3 4  5  6. 7.  8.  9.  10.
 1 2 4 8 16 32 64 128 256 512 1024

 */

/**

 0 1 2 3 4  5  6. 7.  8.  9.  10.
 1 2 4 8 16 32 64 128 256 512 1024

 */
}
