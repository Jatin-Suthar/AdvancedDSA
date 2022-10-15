package BitManipulation;

import java.util.Scanner;

public class GfgSubsetStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		findSubsetUsingBitManipulation(s);
	}
	public static void findSubset(String s, String carry, int idx) {
		if(idx == s.length()) {
			System.out.println(carry);
			return;
		}
		
		char c = s.charAt(idx);
		findSubset(s, carry, idx+1);
		carry+=c;
		findSubset(s, carry, idx+1);
	}
	public static void findSubsetUsingBitManipulation(String s) {
		int len=s.length();
		int lmt = (1<<len)-1;
		for(int i=0; i<=lmt; i++) {
			String substring="";
			for(int j=0; j<len; j++) {
				if((i & (1<<j)) > 0) {
					substring+=s.charAt(j);
				}
			}
			System.out.println(substring);
		}
	}
}
