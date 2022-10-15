package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LeetcodeSortNumberByNumberOfSetBits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) { a[i]=sc.nextInt(); }
		System.out.println(Arrays.toString(sortByBits(a)));
	}
	public static int[] sortByBits(int[] arr) {
        List<Pair> list = new ArrayList<>();
        for(int i: arr) {
            int setBits = numberOfSetBits(i);
            list.add(new Pair(setBits, i));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if(a.bit>b.bit) return 1;
                else if(a.bit==b.bit) return a.val-b.val;
                return -1;
            }
        });
        int k=0;
        for(Pair i: list) {
            arr[k++]=i.val;
        }
        return arr;
    }
    public static int numberOfSetBits(int n) {
        int count=0;
        while(n>0) {
            int rmb=n&-n;
            n-=rmb;
            count++;
        }
        return count;
    }
}
