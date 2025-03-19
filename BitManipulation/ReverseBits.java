package BitManipulation;

import java.util.Scanner;

import static BitManipulation.ReverseBitsSolution.reverseBits;

public class ReverseBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long number = reverseBits(n);
        System.out.println("Number: " + number);
    }

}



class ReverseBitsSolution {
//    public static long reverseBits(long n) {
//        long ans = 0;
//        return n;
//    }
//    public static long convertToNumber(String binary) {
//        long num = 0;
//        int len = binary.length();
//        for(int i=0; i<len; i++) {
//            num += (long) (Math.pow(2, len-i-1)*(binary.charAt(i)-'0'));
//        }
//        return num;
//    }
    public static long reverseBits(long n) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
