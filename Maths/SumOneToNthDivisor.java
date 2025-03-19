package Maths;

public class SumOneToNthDivisor {
    public static int sumOfDivisors(int n) {
        int sum = 1;
        for(int i=2; i<=n; i++) {
            for(int j=1; j*j<=i; j++) {
                if(i%j == 0) {
                    sum += j;
                    if(j!=i/j) {
                        sum += (i/j);
                    }
                }
            }
        }
        return sum;
    }
}