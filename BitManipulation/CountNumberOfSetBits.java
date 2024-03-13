package BitManipulation;

import java.util.Scanner;

public class CountNumberOfSetBits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		while(n>0) {
			int rmb=n&-n;
			n-=rmb;
			count++;
		}
		System.out.println(count);
	}
}