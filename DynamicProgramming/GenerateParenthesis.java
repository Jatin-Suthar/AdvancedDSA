package DynamicProgramming;

import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Solution_GenerateParenthesis solutionGenerateParenthesis = new Solution_GenerateParenthesis();
        List<String> ans = solutionGenerateParenthesis.generateParenthesis(input);
        System.out.println(ans);
    }

}


class Solution_GenerateParenthesis {
    Map<String, Set<String>> dp = new HashMap<>();
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(recur(2*n, ""));
    }

    public Set<String> recur(int n, String s) {
        if(n==0) {
            Set<String> list = new HashSet<>();
            if(valid(s)) {
                list.add(s);
            }
            return list;
        }

        if(dp.get(s)!=null) return dp.get(s);

        Set<String> list = new HashSet<>();

        list.addAll(recur(n-1, s+"("));
        list.addAll(recur(n-1, s+")"));

        if(!list.isEmpty()) {
            dp.put(s, list);
        }
        return list;
    }

    public boolean valid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(c=='(') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}