package MonotonicStack;

import java.util.*;

public class MinOpsToCovertAllElementsToZero {
}

class MinOpsToCovertAllElementsToZeroSolution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            int left = -1;
            while (!stack.isEmpty() && num < stack.peek()) {
                int popped = stack.pop();
                if (popped != left) {
                    ans++;
                }
                left = popped;
            }
            stack.push(num);
        }
        int left = -1;
        while(!stack.isEmpty() && stack.peek() > 0) {
            int popped = stack.pop();
            if(popped != left) {
                ans++;
            }
            left = popped;
        }
        return ans;
    }
}

/*

1 2 3 1 2 3 2 3 4 1
-------------------
0 1 2 0 1 2 1 2 3 0
-------------------
1 2 3

0 1 2 3 4 5  6 7  8  9
----------------------
1 2 3 1 2 3  4 3  4  2
----------------------


1 -> 0,3
2 -> 2,

*/