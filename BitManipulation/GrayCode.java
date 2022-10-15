package BitManipulation;

import java.util.ArrayList;
import java.util.Scanner;

/*
Question Statement: If we have to find the grey code of 3, which the gray code is defined as every time only one digit will change.
					for 1:
					0 1
					for 2:
					00 01 11 10
					for 3:
					000 001 011 010 110 111 101 100

GrayCode Algorithm: when creating gray code for particular n, use recursion with base case for 1: it only have 0 and 1 then add 0 in front of result left to right and add 1 in front of result right to left 
 */

public class GrayCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findGrayCode(n));
	}
	
	@SuppressWarnings("serial")
	public static ArrayList<String> findGrayCode(int n) {
		if(n==1) {
			ArrayList<String> mres = new ArrayList<>() {{
				add("0");
				add("1");
			}};
			return mres;
		}
		ArrayList<String> rres = findGrayCode(n-1);
		ArrayList<String> mres = new ArrayList<>();
		for(int i=0; i<rres.size(); i++) {
			mres.add("0" + rres.get(i));
		}
		for(int i=rres.size()-1; i>=0; i--) {
			mres.add("1" + rres.get(i));
		}
		return mres;
	}
}
