package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchInGraph {
	public static void main(String[] args) {
		List<List<Integer>> adList = new ArrayList<>(10);
		adList.add(List.of());//0
		adList.add(Arrays.asList(2, 6));//1
		adList.add(Arrays.asList(1, 3, 4));//2
		adList.add(List.of(2));//3
		adList.add(Arrays.asList(2, 5));//4
		adList.add(Arrays.asList(4, 8));//5
		adList.add(Arrays.asList(1, 7, 9));//6
		adList.add(Arrays.asList(6, 8));//7
		adList.add(Arrays.asList(5, 7));//8
		adList.add(List.of(6));//9
		traverseInBFS(adList);
	}
	public static void traverseInBFS(List<List<Integer>> graph) {
		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);//so here we defined starting point in queue
		visited[1]=true;//add visited nodes in visited array
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			System.out.print(idx);
			for(int i: graph.get(idx)) {
				if(!visited[i]) queue.add(i);
				visited[i]=true;
			}
		}
	}
}


