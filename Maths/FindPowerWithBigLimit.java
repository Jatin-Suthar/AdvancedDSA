package Maths;

public class FindPowerWithBigLimit {
    final int MOD = 1_000_000_007;
    private long findPower(long num, int n) {
        if(n==1) return num;
        long ans;
        long power = findPower(num, n/2);
        ans = (power * power)%MOD;
        if((n&1) == 1) {
            ans = (ans*num)%MOD;
        }
        return ans;
    }
}
