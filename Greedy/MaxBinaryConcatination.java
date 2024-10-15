package Greedy;

public class MaxBinaryConcatination {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        MaxBinaryConcatinationSolution solution = new MaxBinaryConcatinationSolution();
        System.out.println(solution.maxGoodNumber(arr));
    }

}

class MaxBinaryConcatinationSolution {
    public int maxGoodNumber(int[] nums) {
        String b1 = convertToBinary(nums[0]);
        String b2 = convertToBinary(nums[1]);
        String b3 = convertToBinary(nums[2]);
        return Math.max(convBinToNum(b1+b2+b3), Math.max(convBinToNum(b1+b3+b2),
               Math.max(convBinToNum(b3+b2+b1), Math.max(convBinToNum(b3+b1+b2),
               Math.max(convBinToNum(b2+b1+b3), convBinToNum(b2+b3+b1))))));
    }
    public String convertToBinary(int num) {
        String s = "";
        while(num>0) {
            int rem = num % 2;
            num = num >> 1;
            s = rem + s;
        }
        return s;
    }
    public int convBinToNum(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0; i<s.length(); i++) {
            double pow = Math.pow(2, i);
            sum += (int) (pow*Character.getNumericValue(s.charAt(n-1-i)));
        }
        return sum;
    }
}