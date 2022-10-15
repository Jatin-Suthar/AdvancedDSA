package BitManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCodeSubsetArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a= new int[n];
		for(int i=0; i<n; i++) { a[i]=sc.nextInt(); }
		System.out.println(subsets(a));
	}
	static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return ans;
    }
    public static void helper(int[] a, int idx, List<Integer> list) {
        if(idx>=a.length) {
        	System.out.println(list);
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list = new ArrayList<>(list);
        helper(a, idx+1, list);
        list.add(a[idx]);
        helper(a, idx+1, list);
    }
}	
