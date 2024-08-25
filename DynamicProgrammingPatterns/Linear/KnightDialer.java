package DynamicProgrammingPatterns.Linear;

import java.util.List;

public class KnightDialer {

    public static void main(String[] args) {
        int n = 3;
        KnightDialerSolution solution = new KnightDialerSolution();
        System.out.println(solution.knightDialer(n));
    }

}

class KnightDialerSolution {
    List<List<Integer>> list = List.of(List.of(4,6),
                                       List.of(6,8),
                                       List.of(7,9),
                                       List.of(4,8),
                                       List.of(3,9,0),
                                       List.of(),
                                       List.of(1,7,0),
                                       List.of(2,6),
                                       List.of(1,3),
                                       List.of(2,4));
    int MOD = 1000000007;
    Integer[][] dp;
    public int knightDialer(int n) {
        dp = new Integer[n+1][10];
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count = (count + solve(n-1, i))%MOD;
        }
        return count;
    }

    private int solve(int n, int num) {
        if(n==0) return 1;
        if(dp[n][num]!=null) return dp[n][num];
        List<Integer> vert = list.get(num);
        int count = 0;
        for(int i=0; i<vert.size(); i++){
            count = (count + solve(n-1, vert.get(i)))%MOD;
        }
        return dp[n][num] = count;
    }
}
