package BitManipulation;

import java.util.Scanner;

/*
    Input:
	11000101010110000
		    +
	Two's complement:
	00111010101010000
			=
	00000000000010000
	
*/

public class RightMostSetBit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		System.out.println(n&-n);
	}
}
