package Graphs.TopologicalSort;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        int n = 3, k = 6; String[] dict = {"caa","aaa","aab"};
//        int n = 5, k = 4; String[] dict = {"baa","abcd","abca","cab","cad"};
        AlienDictionarySolution solution = new AlienDictionarySolution();
        System.out.println(solution.findOrder(dict, n, k));
    }

}

class AlienDictionarySolution {
    Stack<Integer> stack = new Stack<>();
    public String findOrder(String[] dict, int n, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int idx = 1; idx < n; idx++) {
            String first = dict[idx - 1];
            String second = dict[idx];
            int i=0, j=0;
            while(i<first.length() && j<second.length() && first.charAt(i) == second.charAt(j)) {
                i++; j++;
            }
            if(i<first.length() && j<second.length()) {
                int key = first.charAt(i) - 'a';
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                list.add(second.charAt(j) - 'a');
                map.put(key, list);
            }
        }

        boolean[] visited = new boolean[k];
        for(int idx = 0; idx < k; idx++) {
            if(!visited[idx]) {
                dfs(map, idx, visited);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append((char) (stack.pop()+'a'));
        }
        return sb.toString();
    }
    public void dfs(Map<Integer, List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        if(adj.get(node)!=null) {
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    dfs(adj, neighbour, visited);
                }
            }
        }
        stack.push(node);
    }
}