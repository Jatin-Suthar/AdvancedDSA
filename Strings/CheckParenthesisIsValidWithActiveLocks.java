package Strings;

import java.util.Stack;

public class CheckParenthesisIsValidWithActiveLocks {

    public static void main(String[] args) {
        String locked = "100000111010",
                    s = "((())(((()()";
        CheckParenthesisIsValidWithActiveLockSolution
                solution = new CheckParenthesisIsValidWithActiveLockSolution();
        System.out.println(solution.canBeValid(s, locked));
    }

}

class CheckParenthesisIsValidWithActiveLockSolution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        return isValid(
                s, locked, false
        ) && isValid(
                s, locked, true
        );
    }
    public boolean isValid(String s, String locked, boolean isReversed) {
        int n = s.length(), op = (isReversed) ? -1 : 1, st = (isReversed) ? n-1 : 0;
        int count = 0;
        for(int i=st; (isReversed) ? (i>=0) : (i<n) ; i+=(op)) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);
            if(lock=='0' && c=='(') {
                count++;
            } else if(c==')') {
                count--;
            } else if(count<0) {
                return false;
            }
        }
        return true;
    }
}
/*
00110000
]][]]][]

010100
]][]]]

01110000
]][[[][]

10
]]

0001101100
]]]]]][][]


000001101000
[][]][[]]]]]

z=5
f=2

*/