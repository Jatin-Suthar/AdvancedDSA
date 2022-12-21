package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraphUsingDfs {
	public static void main(String[] args) {
		List<List<Integer>> adList = new ArrayList<>(4);
		adList.add(Arrays.asList(2));// 0
		adList.add(Arrays.asList(3));// 1
		adList.add(Arrays.asList(0, 3));// 2
		adList.add(Arrays.asList(1, 2));// 3
		System.out.println(isBipartite(adList.size(), adList));
	}
	
	static int[] colors;
    static boolean isBipartite=false;
    
    public static boolean isBipartite(int V, List<List<Integer>> adList)
    {
        colors = new int[V];
		Arrays.fill(colors, -1);
		for(int i=0; i<V; i++) {
		    if(colors[i]==-1) {
		        dfs(i, adList, 0);
		    }
		}
		if(isBipartite) return false;
		return true;
	}

	public static void dfs(int i, List<List<Integer>> adList, int color) {
		colors[i]=color;
		for(int node: adList.get(i)) {
			if(colors[node]==-1) {
				colors[node] = 1-color;
				dfs(node, adList, colors[node]);
			} else if(colors[node]==color) {
				isBipartite=true;
				return;
			}
		}
	}
}
