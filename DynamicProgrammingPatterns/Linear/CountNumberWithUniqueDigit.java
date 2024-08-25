package DynamicProgrammingPatterns.Linear;

public class CountNumberWithUniqueDigit {

    public static void main(String[] args) {
        CountNumberWithUniqueDigitSolution solution = new CountNumberWithUniqueDigitSolution();
        System.out.println("Ans: " + solution.countNumbersWithUniqueDigits(3));
    }

}

class CountNumberWithUniqueDigitSolution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int ans = 10;
        int curr = 9;
        int start = 9;
        while(n-->1 && start!=0) {
            curr *= (start--);
            ans += curr;
        }
        return ans;
    }
    public boolean canAliceWin(int[] nums) {
        int s = 0, d = 0;
        for(int num: nums) {
            if(num<=9) s++;
            else d++;
        }
        return Math.abs(s-d)>=1;
    }
}