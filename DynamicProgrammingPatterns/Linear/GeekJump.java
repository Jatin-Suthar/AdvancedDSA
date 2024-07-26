package DynamicProgrammingPatterns.Linear;

public class GeekJump {
}

class GeekJumpSolution{
    public int minimumEnergy(int arr[],int N){
        if(N==1) return 0;
        Integer[] dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1]-arr[0]);
        for(int i=2; i<N; i++) {
            dp[i] = Math.min(Math.abs(arr[i]-arr[i-1])+dp[i-1], Math.abs(arr[i]-arr[i-2])+dp[i-2]);
        }
        return dp[N-1];
    }
}