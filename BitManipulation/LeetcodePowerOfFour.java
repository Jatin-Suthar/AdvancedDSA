package BitManipulation;

import java.util.Scanner;

public class LeetcodePowerOfFour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(isPowerOf4(n));
	}
	public static boolean isPowerOf4(int n) {
		if(n<=0 && (n&(n-1))!=0) return false;
		return (n-1)%3==0;
	}
}
