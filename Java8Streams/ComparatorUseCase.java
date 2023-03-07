package Java8Streams;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ComparatorUseCase {
	public static void main(String[] args) {
		int[][] a = {{10,50},{60,50}};
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((s1, s2) -> {
			return Integer.compare(s2[1], s1[1]);
		});
		
		for(int[] arr: a) {
			queue.add(arr);
		}
		while(!queue.isEmpty()) {
			System.out.print(Arrays.toString(queue.poll())+" ");
		}
	}
}
