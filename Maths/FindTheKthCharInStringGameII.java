package Maths;

public class FindTheKthCharInStringGameII {
    public static void main(String[] args) {
        System.out.println(new Solution().kthCharacter(100000000000000L, new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
    static class Solution {
        public char kthCharacter(long k, int[] operations) {
            long jump = 0L;
            while(k>1) {
                int idx = (int) (Math.ceil(Math.log(k)/Math.log(2)));
                long half = 1L << (idx-1);
                k -= half;
                jump+=operations[idx-1];
            }
            return (char)('a'+(jump%26));
        }
    }

/*
[0,1,0,1,0]

0: a
1: a|aa
2: a|aa|aabb
3: a|aa|aabb|aabbaabb
4: a|aa|aabb|aabbaabb|aabbaabbbbccbbcc
5: a|aa|aabb|aabbaabb|aabbaabbbbccbbcc|aabbaabbbbccbbccaabbaabbbbccbbcc


#when operation is 0, then k%prevLen = res indx
#when all operations are 0, then char is a + bitCount(k)
*/
}
