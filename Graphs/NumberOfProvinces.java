package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {
	static boolean[] visited;
	
	public static int numberOfProvinces(List<List<Integer>> adjList) {
		int count=0;
		visited=new boolean[adjList.size()];
		for(int i=1; i<adjList.size(); i++) {
			if(!visited[i]) {
				count++;
				dfs(adjList, i);
			}
		}
		return count;
	}
	
	public static void dfs(List<List<Integer>> graph, int idx) {
		visited[idx]=true;
		for(int i: graph.get(idx)) {
			if(!visited[i]) dfs(graph, i);
		}
	}
	
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
		System.out.println(numberOfProvinces(adList));
	}
}
