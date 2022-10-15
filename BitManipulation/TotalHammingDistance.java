package BitManipulation;

import java.util.Scanner;

public class TotalHammingDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++) a[i]=sc.nextInt();
		System.out.println(totalHammingDistance(a));
	}
	public static int totalHammingDistance(int[] nums) {
        int len=nums.length, ans=0;
        for(int i=0; i<32; i++) {
            int counton=0;
            for(int val: nums) {
                if((val&(1<<i)) != 0) {
                    counton++;
                }
            }
            int countoff=len-counton;
            ans += (counton*countoff);
        }
        return ans;
    }
}
