package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectingCycleInUndirectedGraph {
	public static void main(String[] args) {
		//Initialize graph here.
	}
	public static boolean detectCycle(List<List<Integer>> adList) {
		Queue<Box> q = new LinkedList<>();
		int len=adList.size();;
		boolean visited[]=new boolean[len];
		//add starting point of graph
		for(int i=0; i<len; i++) {
    		if(!visited[i]) {
    		    q.add(new Box(i, -1));
        		while(!q.isEmpty()) {
        			Box b=q.poll();
        			int src=b.src, cur=b.cur;
        			visited[cur]=true;
        			for(int val: adList.get(cur)) {
        				if(!visited[val]) {
        					q.add(new Box(val, cur));
        				} else if(visited[val] && val!=src) {
        					return true;
        				}
        			}
        		}
    		}
		}
		return false;
	}
}

class Box {
	int cur;
	int src;
	public Box(int cur, int src) {
		this.cur=cur;
		this.src=src;
	}
}
