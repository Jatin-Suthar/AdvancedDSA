package BitManipulation;

import java.util.Scanner;

/*
Question Statement: we have to find survivor among nth number where we destroy every alternate elements like,
					1 2 3 4 5 6 7 8 9
					  *
					  *   *
					  *   *   *
					  *   *   *   *
					  *   *	  *   *
					* *   *   *   *
					* *   * * *   *
					* *   * * *   * *
					* *   * * * * * *
					
					3 is the survivor among all the nth numbers.
					
Josephus Algorithm: If we have to find the survive we have to first find powerOf2(n) + l,
					then on finding l, just do Output: (2*l)+1.
 */

public class JosephusAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(findSurvivorAmongAlternate(n));
	}
	
	public static int powerOf2(int n) {
		int i=1;
		while(i*2<=n) {
			i*=2;
		}
		return i;
	}
	
	public static int findSurvivorAmongAlternate(int n) {
		int hp2=powerOf2(n);
		int l=n-hp2;
		return (2*l)+1;
	}
}
