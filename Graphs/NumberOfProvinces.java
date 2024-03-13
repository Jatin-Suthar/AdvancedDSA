package Graphs;

import java.util.*;

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
//		List<List<Integer>> adList = new ArrayList<>(10);
//		adList.add(Arrays.asList());//0
//		adList.add(Arrays.asList(2, 6));//1
//		adList.add(Arrays.asList(1, 3, 4));//2
//		adList.add(Arrays.asList(2));//3
//		adList.add(Arrays.asList(2, 5));//4
//		adList.add(Arrays.asList(4, 8));//5
//		adList.add(Arrays.asList(1, 7, 9));//6
//		adList.add(Arrays.asList(6, 8));//7
//		adList.add(Arrays.asList(5, 7));//8
//		adList.add(Arrays.asList(6));//9
//		System.out.println(numberOfProvinces(adList));

		int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
		Solution solution = new Solution();
		System.out.println(solution.findCircleNum(nums));
	}

	static class Solution {
		public int findCircleNum(int[][] nums) {
			Set<Integer>[] nodes = new HashSet[nums.length+1];
			System.out.println();
			int n = nums.length;
			int m = nums[0].length;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(nums[i][j]==1) {
						nodes[i+1] = (nodes[i+1]==null) ? new HashSet<>() : nodes[i+1];
						nodes[i+1].add(j+1);
						nodes[j+1] = (nodes[j+1]==null) ? new HashSet<>() : nodes[j+1];
						nodes[j+1].add(i+1);
					}
				}
			}
			boolean[] visited = new boolean[nums.length+1];
			int count=0;
			for(int i=1; i<nodes.length; i++) {
				if(!visited[i]) {
					count++;
					dfs(nodes, visited, i);
				}
			}
			return count;
		}

		void dfs(Set<Integer>[] nodes, boolean[] visited, int idx) {
			visited[idx]=true;
			for(int i: nodes[idx]) {
				if(!visited[i]) {
					dfs(nodes, visited, i);
				}
			}
		}
	}

}
