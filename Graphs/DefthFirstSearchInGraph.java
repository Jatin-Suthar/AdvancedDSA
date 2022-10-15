package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefthFirstSearchInGraph {
	static boolean[] visited;
	
	public static void main(String[] args) {
		List<List<Integer>> adList = new ArrayList<>(10);
		adList.add(Arrays.asList());//0
		adList.add(Arrays.asList(2, 6));//1
		adList.add(Arrays.asList(1, 3, 4));//2
		adList.add(Arrays.asList(2));//3
		adList.add(Arrays.asList(2, 5));//4
		adList.add(Arrays.asList(4, 8));//5
		adList.add(Arrays.asList(1, 7, 9));//6
		adList.add(Arrays.asList(6, 8));//7
		adList.add(Arrays.asList(5, 7));//8
		adList.add(Arrays.asList(6));//9
		visited=new boolean[adList.size()];
		traverseInDFS(adList, 1);
	}
	
	public static void traverseInDFS(List<List<Integer>> graph, int idx) {
		System.out.println(idx);
		visited[idx]=true;
		for(int i: graph.get(idx)) {
			if(!visited[i]) traverseInDFS(graph, i);
		}
	}
}
