package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/*
Leetcode Link: https://leetcode.com/problems/divisor-game/
*/
public class DivisorGame {
	public static void main(String[] args) {
		List<Integer> testCases = Arrays.asList(1001, 1002, 1003, 1004, 1005, 20201, 20221, 20203401);
		testCases.forEach(value -> System.out.println(value + " -> " + isAliceWin(value)));
		
	}
	
	private static boolean isAliceWin(int n) {
		return n%2==0;
	}

	public static boolean isAliceWinByDP(int n) {
		boolean[] alice = new boolean[n+1];
		if(n<=1) return alice[n];
		boolean[] bob = new boolean[n+1];
		alice[1]=false;
		alice[2]=true;
		bob[1]=!alice[1];
		bob[2]=!alice[2];
		for(int i=3; i<=n; i++) {
			for(int j=i-1; j>=1; j--) {
				if(i%(i-j)==0 && bob[j]) {
					alice[i]=true;
					bob[i]=false;
					continue;
				}
			}
			if(!alice[i]) bob[i]=true;
		}
		return alice[n];
	}
}
