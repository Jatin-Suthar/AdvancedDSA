package SlidingWindow;

import java.util.*;

public class NumberOfSubstringWithDominantOnes {

    public static void main(String[] args) {
        NumberOfSubstringWithDominantOnesSolution solution = new NumberOfSubstringWithDominantOnesSolution();
        System.out.println(solution.numberOfSubstrings("00011")); // Output: 5
        System.out.println(solution.numberOfSubstrings("101101")); // Output: 16
    }

}

class NumberOfSubstringWithDominantOnesSolution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int count = 0;
        List<Integer> zeroIdx = new ArrayList<>();
        zeroIdx.add(-1);

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') zeroIdx.add(i);

            int m = zeroIdx.size();
            int num = 0;
            int idx = i;
            int prevIdx;
            for (int j = m - 1; j >= 0; --j) {
                int val = num * num;
                if (val > i + 1) break;
                prevIdx = idx;
                idx = zeroIdx.get(j);
                int numOne = i - idx - num;

                if (numOne >= val) {
                    count += Math.min(numOne - val + 1, prevIdx - idx);
                }

                num++;
            }
        }
        return count;
    }
}