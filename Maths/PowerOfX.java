package Maths;

public class PowerOfX {

    public double myPow(double x, int n) {
        long power = n;
        if(power<0) power = -1 * power;
        double ans = 1.0;
        while(power>0) {
            if(power%2==1) {
                ans*=x;
                power-=1;
            } else {
                x*=x;
                power/=2;
            }
        }
        if(n<0) return (double) 1/(double) ans;
        return (double) ans;
    }

}
