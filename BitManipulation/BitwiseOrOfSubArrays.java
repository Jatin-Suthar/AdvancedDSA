package BitManipulation;

import java.util.*;

public class BitwiseOrOfSubArrays {
    public static void main(String[] args) {
        System.out.println(new Solution().subarrayBitwiseORs(new int[] {1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1}));
    }
    static class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> set = new HashSet<>();
            int[] bits = new int[32];
            int prev = 0;
            for (int k : arr) {
                set.add(k);
                int or = prev;
                for (int j = 0; j < 32; j++) {
                    if ((k & (1 << j)) > 0 && bits[j] == 0) {
                        bits[j]++;
                        or |= (1 << j);
                        set.add(or);
                    }
                }
                prev = or;
            }
            return set.size();
        }
        public int countSetBits(int or) {
            int count = 0;
            for(int i=0; i<32; i++) {
                if((or & (1 << i)) > 0) count++;
            }
            return count;
        }
    }
/**

 [1,9,8,32,40,41]

 101001



 */
}
