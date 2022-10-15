package BitManipulation;

import java.util.Scanner;

public class LeetCodeBitwiseANDofGivenRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int left = sc.nextInt();
		int right = sc.nextInt();
		while(right>left) {
			right &= right-1;
		}
		System.out.println(right);
	}
}
